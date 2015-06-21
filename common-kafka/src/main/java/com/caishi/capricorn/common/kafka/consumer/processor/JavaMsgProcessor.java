package com.caishi.capricorn.common.kafka.consumer.processor;

import java.io.Serializable;

/**
 * Created by apple on 15/6/15.
 * 标记接口
 * 采用java序列化接口
 */
public interface JavaMsgProcessor<E extends Serializable> extends MsgProcessor<E> {


}
