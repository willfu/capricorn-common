package com.caishi.capricorn.common.lock.locker.impl;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by yeyanchao on 15/6/25.
 * 基于Redis的分布式锁
 */
public class RedisLocker extends AbstractRedisLocker<Jedis> {

	private JedisPool jedisPool;

	private long timeOut;

	public RedisLocker(JedisPool jedisPool, long timeOut) {
		this.jedisPool = jedisPool;
		this.timeOut = timeOut;
	}

	@Override
	protected Jedis getRedis() {
		return jedisPool.getResource();
	}

	@Override
	protected void returnRedis(Jedis jedis) {
		jedisPool.returnResourceObject(jedis);
	}
}
