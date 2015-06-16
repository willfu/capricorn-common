package com.caishi.capricorn.common.kafka.producer;

import com.caishi.capricorn.common.kafka.consumer.ConsumerContainer;
import com.caishi.capricorn.common.kafka.consumer.processor.JavaMsgProcessor;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessor;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessorInfo;
import com.caishi.capricorn.common.kafka.consumer.processor.StringMsgProcessor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 15/6/15.
 */
public class ConsumerTest {

	public static void test(String[] args) throws Exception {
		ConsumerContainer consumerContainer = new ConsumerContainer();
		consumerContainer.setZkConnect("10.10.1.54:2181");
		ConcurrentMap<MsgProcessorInfo, MsgProcessor> msgProcessors = new ConcurrentHashMap<MsgProcessorInfo, MsgProcessor>();
		msgProcessors.put(new MsgProcessorInfo("test", "hello1"), new StringMsgProcessor() {
			private final Logger LOGGER = LoggerFactory.getLogger(JavaMsgProcessor.class);
			public void process(String element) {
				LOGGER.error("****************" + element);
			}
		});

		consumerContainer.setMsgProcessorMap(msgProcessors);

		consumerContainer.start();

		TimeUnit.SECONDS.sleep(10000);

		consumerContainer.stop();
	}

	/**
	 * 未实现
	 *
	 * @throws Exception
	 */
	private static void testNewAPI() throws Exception {
		Properties props = new Properties();
		props.put("bootstrap.servers", "10.10.1.54:9092");
		props.put("group.id", "test");
		props.put("session.timeout.ms", "1000");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "10000");
		props.put("key.deserializer", StringDeserializer.class);
		props.put("value.deserializer", StringDeserializer.class);
		props.put("partition.assignment.strategy", "range");

		KafkaConsumer consumer = new KafkaConsumer(props);
		consumer.subscribe("yyc");

		while (true) {
			Map<String, ConsumerRecords<String, String>> records = consumer.poll(10000000);
			if (records == null) {
				TimeUnit.SECONDS.sleep(10);
				continue;
			}
			for (Map.Entry<String, ConsumerRecords<String, String>> entry : records.entrySet()) {
				System.out.println(entry.getKey());
				List<ConsumerRecord<String, String>> recordsPerTopic = entry.getValue().records();

				for (ConsumerRecord<String, String> record : recordsPerTopic) {
					System.out.println(record.key() + " : " + record.value());
				}
			}
		}
	}
}
