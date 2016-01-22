package com.caishi.capricorn.common.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import static com.caishi.capricorn.common.redis.constants.RedisConstants.REDIS_KEY_CHARSET;


/**
 * Created by apple on 16/1/12.
 */
public class LongRedisSerializer implements RedisSerializer<Long> {
	@Override
	public byte[] serialize(Long aLong) throws SerializationException {
		if (aLong == null) {
			throw new IllegalArgumentException("integer is null.");
		}
		return aLong.toString().getBytes(REDIS_KEY_CHARSET);
	}

	@Override
	public Long deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null) {
			return null;
		}
		String longStr = new String(bytes, REDIS_KEY_CHARSET);
		return Long.valueOf(longStr);
	}
}
