package com.caishi.capricorn.common.lock.locker.impl;

import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import redis.clients.jedis.Jedis;

/**
 * Created by yeyanchao on 15/6/25.
 */
public class JodisLocker extends AbstractRedisLocker<Jedis> {

	private JedisResourcePool jedisResourcePool;

	private String zkHosts;

	private int zkSessionTimeout = 30000;

	private String database;

	public JodisLocker(String zkHosts, int zkSessionTimeout, String database, long timeout) {
		this.zkHosts = zkHosts;
		this.zkSessionTimeout = zkSessionTimeout;
		this.database = database;
		this.timeout = timeout;
	}

	@Override
	protected Jedis getRedis() {
		try {
			if (null == jedisResourcePool) {
				jedisResourcePool = RoundRobinJedisPool.create()
						.curatorClient(zkHosts, zkSessionTimeout).zkProxyDir("/zk/codis/" + database + "/proxy").build();
			}

			return jedisResourcePool.getResource();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Override
	protected void returnRedis(Jedis jedis) {
		// close would just return to pool if data resource is still available
		jedis.close();
	}


}
