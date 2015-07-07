package com.caishi.capricorn.common.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * Created by apple on 15/7/6.
 */
public class RedisTemplateExt<K, V> extends RedisTemplate<K, V> {

	/**
	 * 为shards connection 事务开启一个方便入口，
	 * 以及特定 hash key的场景
	 * 或者key，value不是string类型的
	 *
	 * @param <T>
	 * @param shardsSeesionCallback
	 * @param key                   做sharding hash 所使用的key，保证在一台机器上
	 * @return
	 */
	public <T> T executeForShards(ShardsSeesionCallback<T> shardsSeesionCallback, String key) {
		RedisConnectionFactory factory = getConnectionFactory();
		// bind connection
		RedisConnection redisConnection = RedisConnectionUtils.bindConnection(factory);
		Object object = redisConnection.getNativeConnection();
		Jedis jedis = null;
		if (object instanceof Jedis) {
			jedis = (Jedis) object;
		} else if (object instanceof ShardedJedis) {
			ShardedJedis shardedJedis = (ShardedJedis) object;
			jedis = shardedJedis.getShard(key);
		} else {
			RedisConnectionUtils.unbindConnection(factory);
			throw new IllegalArgumentException("this method only service for shardedJedis and jedis scene");
		}
		try {
			return shardsSeesionCallback.execute(jedis);
		} finally {
			RedisConnectionUtils.unbindConnection(factory);
		}
	}
}
