package com.caishi.capricorn.common.kafka.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by apple on 15/8/18.
 */
public class JSONSerializer<T> implements Serializer<T> {
	private String encoding = "UTF8";

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
		Object encodingValue = configs.get(propertyName);
		if (encodingValue == null)
			encodingValue = configs.get("serializer.encoding");
		if (encodingValue != null && encodingValue instanceof String)
			encoding = (String) encodingValue;
	}

	@Override
	public byte[] serialize(String topic, T data) {
		try {
			return JSON.toJSONString(data).getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException("Error when serializing object to byte[] due to unsupported encoding " + encoding);
		}
	}

	@Override
	public void close() {

	}
}
