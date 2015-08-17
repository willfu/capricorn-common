package com.caishi.capricorn.common.kafka.producer;

import com.caishi.capricorn.common.utils.PropertiesUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * Buffered producer with hosted thread pool. It could be used to send any<br>
 * serializable java objects those share same broker cluster. <br>
 *
 *    Example 1) Simple usage:
 *    <pre>
 *    QueuedProducer queuedProducer = new QueuedProducer("10.10.1.64:9092");
 *    FeedMessage message = FeedMessage();
 *    message.setTitle("test title);
 *    ......
 *    queuedProducer.send("test-topic", message);
 *    </pre>
 *
 *    Example 2) sync send with concurrency to 10:
 *    <pre>
 *    QueuedProducer queuedProducer = new QueuedProducer("10.10.1.64:9092", 10, true);
 *    FeedMessage message = FeedMessage();
 *    message.setTitle("test title);
 *    ......
 *    queuedProducer.send("test-topic", message);
 *    </pre>
 *
 *    Example 3) sync send with customized serializer and settings in properties:
 *    <pre>
 *    Properties props = new Properties();
 *    props.put(QueuedProducer.BROKER_LIST, "10.10.1.64:9092");
 *    props.put(QueuedProducer.SENDING_CONCURRENCY, "10");
 *    props.put(QueuedProducer.SYNC_SEND, "true");
 *    props.put(QueuedProducer.VALUE_SERIALIZER_CLASS, "$(CLASSPATH OF YOUR CUSTOMIZED SERIALIZER CLASS WHICH IMPLEMENTS @Serializer\<T\> class");
 *    QueuedProducer queuedProducer = new QueuedProducer(props);
 *    FeedMessage message = FeedMessage();
 *    message.setTitle("test title);
 *    ......
 *    queuedProducer.send("test-topic", message);
 *    </pre>
 * @author humphrey.han@9icaishi.net
 * @since 0.0.1
 */
public class QueuedProducer {

    private final static Logger logger = LoggerFactory.getLogger(QueuedProducer.class);

    private ThreadPoolExecutor threadPool;

    private BlockingQueue<Runnable> messageQueue;

    final KafkaProducer<Serializable,Serializable> producer;

    final boolean syncSend;

    public static final String SYNC_SEND = "syncsend";
    public static final String SENDING_CONCURRENCY = "concurrency";
    public static final String BROKER_LIST = "bootstrap.servers";
    public static final String VALUE_SERIALIZER_CLASS = "value.serializer";
    public static final String KEY_SERIALIZER_CLASS = "key.serializer";

    public static final String DEFAULT_KAFKA_CONFIG = "META-INF/com/caishi/capricorn/common/kafka/producer/default-kafka-produce-config.properties";

        public QueuedProducer(String brokerList) {
            this(brokerList, 5, false);
        }

        public QueuedProducer(String brokerList, int concurrency) {
            this(brokerList, concurrency, false);
        }

        public QueuedProducer(String brokerList, int concurrency, boolean syncSend) {
            Properties props = PropertiesUtil.loadProperties(DEFAULT_KAFKA_CONFIG);
            props.put(BROKER_LIST, brokerList);

            producer = new KafkaProducer<Serializable,Serializable>(props);
            initThreadPool(concurrency);
            this.syncSend = syncSend;
        }

    public QueuedProducer(Properties properties) {
        Properties configs = PropertiesUtil.mergeProperties(
                // load default kafka settings
                PropertiesUtil.loadProperties(DEFAULT_KAFKA_CONFIG),
                // over write with custom settings
                properties);

        producer = new KafkaProducer<Serializable,Serializable>(configs);

        int concurrency = Integer.parseInt(configs.getProperty(SENDING_CONCURRENCY, "5"));
        initThreadPool(concurrency);
        this.syncSend = Boolean.parseBoolean(configs.getProperty(SYNC_SEND, "false"));
    }

    private void initThreadPool(int concurrency) {
        messageQueue = new LinkedBlockingDeque<Runnable>();
        threadPool = new ThreadPoolExecutor(concurrency, concurrency,
                0L, TimeUnit.MILLISECONDS,
                messageQueue);
    }

    public void sendMessage(String topic, Serializable key, Serializable message) {
        ProducerRecord<Serializable,Serializable> producerRecord = new ProducerRecord<Serializable,Serializable>(topic, key, message);

        SendTask sendTask = new SendTask(producerRecord);
        threadPool.submit(sendTask);
    }

    public void sendMessage(String topic, Serializable message) {
        ProducerRecord<Serializable,Serializable> producerRecord = new ProducerRecord<Serializable,Serializable>(topic, message);

        SendTask sendTask = new SendTask(producerRecord);
        threadPool.submit(sendTask);
    }

    public void close() throws InterruptedException {
        this.threadPool.shutdown();
        this.threadPool.awaitTermination(60, TimeUnit.SECONDS);
        this.producer.close();
    }

    /**
     * ============= Task of source crawling ============
     */
    class SendTask implements  Runnable {
        private ProducerRecord<Serializable,Serializable> message;

        public SendTask(ProducerRecord<Serializable, Serializable> producerRecord) {
            this.message= producerRecord;
        }

        public void run() {
            try {
                Future<RecordMetadata> future = producer.send(message);
                if (syncSend) {
                    try {
                        RecordMetadata recordMetadata = future.get();
                        logger.debug("Successfully sync sent message " + message + "  to kafka [partition:" + recordMetadata.partition() +
                                ",offset:" + recordMetadata.offset() + "]");
                    } catch (Exception e) {
                        logger.error("Exception to get metadata of sent message " + message + e.getMessage());
                    }
                } else {
                    logger.debug("Async delivered " + message + " to kafka");
                }
            } catch (Throwable throwable) {
                logger.error(throwable.getMessage(), throwable);
            }
        }

    }
}
