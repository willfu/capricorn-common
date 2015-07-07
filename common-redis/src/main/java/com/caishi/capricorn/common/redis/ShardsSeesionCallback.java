package com.caishi.capricorn.common.redis;

import org.springframework.dao.DataAccessException;
import redis.clients.jedis.Jedis;

/**
 * Created by apple on 15/7/6.
 */
public interface ShardsSeesionCallback<T> {
	T execute(Jedis jedis) throws DataAccessException;
}
