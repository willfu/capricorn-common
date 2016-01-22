package com.caishi.capricorn.common.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import static com.caishi.capricorn.common.redis.constants.RedisConstants.REDIS_KEY_CHARSET;

/**
 * Created by apple on 15/9/9.
 */
public class IntegerRedisSerializer implements RedisSerializer<Integer> {
	@Override
	public byte[] serialize(Integer integer) throws SerializationException {
		if (integer == null) {
			throw new IllegalArgumentException("integer is null.");
		}
		return integer.toString().getBytes(REDIS_KEY_CHARSET);
	}

	@Override
	public Integer deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null) {
			return null;
		}
		String integerStr = new String(bytes, REDIS_KEY_CHARSET);
		return Integer.valueOf(integerStr);
	}
}
