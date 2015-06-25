package com.caishi.capricorn.common.lock.locker.impl;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by yeyanchao on 15/6/25.
 */
public class ShardRedisLocker extends AbstractRedisLocker<ShardedJedis> {

	private ShardedJedisPool shardJedisPool;

	private long timeout;

	public ShardRedisLocker(ShardedJedisPool shardJedisPool, long timeout) {
		this.shardJedisPool = shardJedisPool;
		this.timeout = timeout;
	}

	private ShardedJedis getShardJedis() {
		return shardJedisPool.getResource();
	}

	private void returnShardJedis(ShardedJedis shardedJedis) {
		shardJedisPool.returnResourceObject(shardedJedis);
	}

	@Override
	protected ShardedJedis getRedis() {
		return shardJedisPool.getResource();
	}

	@Override
	protected void returnRedis(ShardedJedis shardedJedis) {
		shardJedisPool.returnResourceObject(shardedJedis);
	}
}
