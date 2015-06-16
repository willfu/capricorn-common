package com.caishi.capricorn.common.kafka.consumer;

import com.caishi.capricorn.common.kafka.consumer.processor.JavaMsgProcessor;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessor;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessorInfo;
import com.caishi.capricorn.common.kafka.consumer.processor.StringMsgProcessor;
import com.caishi.capricorn.common.kafka.serialization.DefaultObjectDeserializer;
import com.caishi.capricorn.common.utils.PropertiesUtil;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by apple on 15/6/15.
 * 1.zkConnect: host1:port1,host2:port2...
 */
public class ConsumerContainer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerContainer.class);

	public static final String DEFAULT_CONSUMER_CONFIG = "META-INF/com/caishi/capricorn/common/kafka/consumer/default-kafka-consumer-config.properties";

	public static Properties DEFAULT_PROPERTIES;

	public static final String ZK_CONNECT = "zookeeper.connect";
	public static final String GROUP_ID = "group.id";
	public static final String ZK_SESSION = "zookeeper.session.timeout.ms";
	public static final String ZK_SYNC = "zookeeper.sync.time.ms";
	public static final String COMMIT_TIME = "auto.commit.interval.ms";

	/**
	 * 支持编码方式
	 */
	private static final Set<Class<? extends MsgProcessor>> DESERIALIZER_PROCESSOR = new HashSet<Class<? extends MsgProcessor>>();
	private static final Map<Class<? extends MsgProcessor>, Deserializer> CLASS_DESERIALIZER_MAP = new HashMap<Class<? extends MsgProcessor>, Deserializer>();

	static {
		DEFAULT_PROPERTIES = PropertiesUtil.loadProperties(DEFAULT_CONSUMER_CONFIG);
		DESERIALIZER_PROCESSOR.add(JavaMsgProcessor.class);
		DESERIALIZER_PROCESSOR.add(StringMsgProcessor.class);
		CLASS_DESERIALIZER_MAP.put(JavaMsgProcessor.class, new DefaultObjectDeserializer());
		CLASS_DESERIALIZER_MAP.put(StringMsgProcessor.class, new StringDeserializer());
	}

	private String zkConnect;

	/**
	 * 消息处理器：外部配置
	 */
	private ConcurrentMap<MsgProcessorInfo, MsgProcessor> msgProcessorMap;

	/**
	 * 消息处理器--编解码器 mapping
	 */
	private ConcurrentMap<MsgProcessorInfo, Deserializer> msgDeserializerMap = new ConcurrentHashMap<MsgProcessorInfo, Deserializer>();

	/**
	 * 未消息处理器建立连接 : 减少重复连接
	 */
	private ConcurrentMap<MsgProcessorInfo, ConsumerConnector> topicConsumers = new ConcurrentHashMap<MsgProcessorInfo, ConsumerConnector>();

	private ExecutorService executorService;

	private int totalThreadNum;

	private AtomicBoolean running = new AtomicBoolean(false);


	public String getZkConnect() {
		return zkConnect;
	}

	public void setZkConnect(String zkConnect) {
		this.zkConnect = zkConnect;
	}

	public ConcurrentMap<MsgProcessorInfo, MsgProcessor> getMsgProcessorMap() {
		return msgProcessorMap;
	}

	public void setMsgProcessorMap(ConcurrentMap<MsgProcessorInfo, MsgProcessor> msgProcessorMap) {
		this.msgProcessorMap = msgProcessorMap;
	}

	public synchronized void start() {
		if (StringUtils.isBlank(zkConnect)) {
			throw new IllegalArgumentException("The zkConnect for kafka consumer container is null.");
		}
		validateProcessorConfig(msgProcessorMap);
		if (isRunning()) {
			throw new IllegalStateException(String.format("kafka consumer for %s is already in running.", zkConnect));
		}
		/**
		 * 启动 kafka consumer
		 */
		doStart();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Kafka consumer container for %s is running.", zkConnect));
		}
		running.set(true);
	}

	/**
	 * 1.检测配置文件
	 * 2.适配 MsgProcessor 的反序列化器
	 *
	 * @param processorMap
	 */
	private void validateProcessorConfig(Map<MsgProcessorInfo, MsgProcessor> processorMap) {
		if (msgProcessorMap == null || msgProcessorMap.isEmpty()) {
			throw new IllegalArgumentException(String.format("There is no processor for %s kafka.", zkConnect));
		}
		for (Map.Entry<MsgProcessorInfo, MsgProcessor> entry : processorMap.entrySet()) {
			MsgProcessorInfo key = entry.getKey();
			/**
			 * validate MsgProcessorInfo
			 * 1. set zkconnect
			 */
			key.validate(this.zkConnect);

			/**
			 * validate MsgProcessor
			 */
			MsgProcessor processor = entry.getValue();
			if (processor == null) {
				throw new IllegalArgumentException(String.format("The processor of kafka consumer container %s is null.", key));
			}
			boolean supportEncoded = false;
			for (Class<? extends MsgProcessor> processorType : DESERIALIZER_PROCESSOR) {
				if (processorType.isInstance(processor)) {
					supportEncoded = true;
					msgDeserializerMap.putIfAbsent(key, CLASS_DESERIALIZER_MAP.get(processorType));
				}
			}

			if (!supportEncoded) {
				throw new IllegalArgumentException(String.format("The deserialize of the msg processor for %s is unsupported.", key));
			}

			totalThreadNum += key.getThreadNum();
		}
	}

	/**
	 * 1.创建线程池
	 * 2.启动消息处理器
	 */
	private void doStart() {
		executorService = Executors.newFixedThreadPool(totalThreadNum, new ThreadFactory() {
			private AtomicInteger count = new AtomicInteger(0);

			public Thread newThread(Runnable r) {
				return new Thread(r, "kafka consumer thread#" + count.get());
			}
		});

		for (Map.Entry<MsgProcessorInfo, MsgProcessor> entry : msgProcessorMap.entrySet()) {
			startConsumer(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * 1.连接kafka
	 * 2.处理消息
	 *
	 * @param msgProcessorInfo
	 * @param msgProcessor
	 */
	private void startConsumer(MsgProcessorInfo msgProcessorInfo, MsgProcessor msgProcessor) {
		if (topicConsumers.containsKey(msgProcessorInfo)) {
			LOGGER.info(String.format("Kafka connection for %s is already existed.", msgProcessorInfo));
			return;
		}

		ConsumerConnector connector = Consumer.createJavaConsumerConnector(createConsumerConfig(this.zkConnect, msgProcessorInfo));
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(msgProcessorInfo.getTopic(), msgProcessorInfo.getThreadNum());
		Map<String, List<KafkaStream<byte[], byte[]>>> messageStreams = connector.createMessageStreams(topicCountMap);

		List<KafkaStream<byte[], byte[]>> kafkaStreams = messageStreams.get(msgProcessorInfo.getTopic());

		for (KafkaStream<byte[], byte[]> kafkaStream : kafkaStreams) {
			executorService.submit(new ConsumerWorker(msgProcessorInfo.getTopic(), kafkaStream, msgProcessor, msgDeserializerMap.get(msgProcessorInfo)));
		}

		topicConsumers.putIfAbsent(msgProcessorInfo, connector);
	}


	/**
	 * 消息处理器：
	 * 1.解码消息
	 * 2.处理消息
	 */
	private static class ConsumerWorker implements Runnable {
		private String topic;
		private KafkaStream<byte[], byte[]> msgStream;
		private MsgProcessor msgProcessor;
		private Deserializer deserializer;

		public ConsumerWorker(String topic, KafkaStream<byte[], byte[]> msgStream, MsgProcessor msgProcessor, Deserializer deserializer) {
			this.topic = topic;
			this.msgStream = msgStream;
			this.msgProcessor = msgProcessor;
			this.deserializer = deserializer;
		}

		public void run() {
			ConsumerIterator<byte[], byte[]> iterator = msgStream.iterator();
			while (iterator.hasNext()) {
				byte[] bytes = iterator.next().message();
				Object message = deserializer.deserialize(topic, bytes);
				msgProcessor.process(message);
			}
		}
	}

	private ConsumerConfig createConsumerConfig(String zkConnect, MsgProcessorInfo msgProcessorInfo) {
		Properties props = new Properties();
		props.put(ZK_CONNECT, msgProcessorInfo.getZkConnect());
		props.put(GROUP_ID, msgProcessorInfo.getGroupId());
		PropertiesUtil.mergeProperties(DEFAULT_PROPERTIES, props);
		return new ConsumerConfig(props);
	}


	public boolean isRunning() {
		return running.get();
	}

	public void stop() {
		if (!isRunning()) {
			throw new IllegalStateException("Kafka consumer container is still stopped");
		}

		doStop();

		running.set(false);
	}

	private void doStop() {
		if (topicConsumers != null && !topicConsumers.isEmpty()) {
			for (Map.Entry<MsgProcessorInfo, ConsumerConnector> entry : topicConsumers.entrySet()) {
				entry.getValue().shutdown();
			}
		}
		if (executorService != null) {
			executorService.shutdown();
		}

		try {
			if (!executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
				System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted during shutdown, exiting uncleanly");
		}
	}


}
