package com.caishi.capricorn.common.kafka.constants;

/**
 * Created by apple on 15/8/21.
 * <p/>
 * kafka 配置
 */
public class KafkaConfigKey {

	/**
	 * consumer config
	 */

	public static final String ZK_CONNECT = "zookeeper.connect";

	public static final String GROUP_ID = "group.id";

	public static final String ZK_SESSION = "zookeeper.session.timeout.ms";

	public static final String ZK_SYNC = "zookeeper.sync.time.ms";

	public static final String COMMIT_TIME = "auto.commit.interval.ms";
}
