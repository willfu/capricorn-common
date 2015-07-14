package com.caishi.capricorn.common.kafka.spring;

import com.caishi.capricorn.common.kafka.consumer.ConsumerContainer;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessor;
import com.caishi.capricorn.common.kafka.consumer.processor.MsgProcessorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by apple on 15/6/15.
 */
public class SpringKafkaConsumerContainer implements SmartLifecycle {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringKafkaConsumerContainer.class);


	private ConsumerContainer consumerContainer;

	private String zkConnect;

	private ConcurrentMap<MsgProcessorInfo, MsgProcessor> msgProcessorMap;

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

	@Override
	public void start() {
		initConsumerContainer();
		consumerContainer.start();
	}

	private void initConsumerContainer() {
		this.consumerContainer = new ConsumerContainer();
		consumerContainer.setZkConnect(zkConnect);
		consumerContainer.setMsgProcessorMap(this.msgProcessorMap);
	}

	@Override
	public void stop() {
		consumerContainer.stop();
	}

	@Override
	public boolean isRunning() {
		if (consumerContainer == null) {
			return false;
		}
		return consumerContainer.isRunning();
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		callback.run();
		stop();
	}

	@Override
	public int getPhase() {
		return 0;
	}
}
