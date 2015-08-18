package com.caishi.capricorn.common.kafka.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by apple on 15/8/18.
 */
public class JSONDeserializer<T> implements Deserializer<T> {
	private String encoding = "UTF8";

	private Class<T> clazz;

	public JSONDeserializer(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
		Object encodingValue = configs.get(propertyName);
		if (encodingValue == null)
			encodingValue = configs.get("deserializer.encoding");
		if (encodingValue != null && encodingValue instanceof String)
			encoding = (String) encodingValue;
	}

	@Override
	public T deserialize(String topic, byte[] data) {
		try {
			return JSON.parseObject(new String(data, encoding), clazz);
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException("Error when deserializing byte[] to string due to unsupported encoding " + encoding);
		}
	}

	@Override
	public void close() {

	}
}
