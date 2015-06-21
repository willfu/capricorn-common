package com.caishi.capricorn.common.kafka.consumer.processor;

/**
 * Created by apple on 15/6/15.
 * 消息处理器：
 * PS：请确保消息处理器是 Thread safe
 */
public interface MsgProcessor<E> {

	/**
	 * 初始化消息处理器信息
	 */
	void init();

	/**
	 * 处理消息
	 *
	 * @param element
	 */
	void process(E element);

	/**
	 * 释放消息处理器资源
	 */
	void destroy();
}
