package com.caishi.capricorn.common.kafka.consumer.processor;

/**
 * Created by apple on 15/6/15.
 * 消息处理器
 */
public interface MsgProcessor<E> {

	void process(E element);
}
