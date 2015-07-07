package com.caishi.capricorn.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

/**
 * 支持分布式redis连接池
 *
 * Created by apple on 15/7/6.
 */
public class ShardedJedisConnectionFactory implements RedisConnectionFactory, InitializingBean, DisposableBean {
	private final static Logger log = LoggerFactory.getLogger(ShardedJedisConnectionFactory.class);


	private ShardedJedisPool shardedJedisPool = null;
	private JedisPoolConfig shardedPoolConfig = new JedisPoolConfig();
	private List<JedisShardInfo> shards;


	public ShardedJedisConnectionFactory() {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (shardedPoolConfig != null) {
			shardedJedisPool = new ShardedJedisPool(shardedPoolConfig, shards);
		}

	}

	@Override
	public void destroy() throws Exception {
		if (shardedJedisPool != null) {
			try {
				shardedJedisPool.destroy();
			} catch (Exception e) {
				log.error("Cannot properly close Sharded Jedis pool", e);
			}
		}
		shardedJedisPool = null;
	}

	@Override
	public RedisConnection getConnection() {
		Assert.notNull(shardedJedisPool, "sharded jedis pool is null,check config and make sure spring context is started");
		try {
			return new ShardedJedisConnection(shardedJedisPool.getResource(), shardedJedisPool);
		} catch (Exception ex) {
			throw new DataAccessResourceFailureException("Cannot get shared Jedis connection", ex);
		}
	}

	/**
	 * Specifies if pipelined results should be converted to the expected data type. If false, results of
	 * {@link RedisConnection#closePipeline()} and {RedisConnection#exec()} will be of the type returned by the underlying
	 * driver This method is mostly for backwards compatibility with 1.0. It is generally always a good idea to allow
	 * results to be converted and deserialized. In fact, this is now the default behavior.
	 *
	 * @return Whether or not to convert pipeline and tx results
	 */
	@Override
	public boolean getConvertPipelineAndTxResults() {
		return false;
	}

	/**
	 * @return
	 * @since 1.4
	 */
	@Override
	public RedisSentinelConnection getSentinelConnection() {
		throw new UnsupportedOperationException();
	}


	public void releaseConnection(boolean broken, ShardedJedis client) {
		Assert.notNull(shardedJedisPool, "sharded jedis pool is null,check config and make sure spring context is started");
		try {
			if (broken) {
				shardedJedisPool.returnBrokenResource(client);
			} else {
				shardedJedisPool.returnResource(client);
			}
		} catch (Exception ex) {
			shardedJedisPool.returnBrokenResource(client);
		}
	}


	/**
	 * @return the shardedJedisPool
	 */
	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}


	/**
	 * @param shardedJedisPool the shardedJedisPool to set
	 */
	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}


	/**
	 * @return the shardedPoolConfig
	 */
	public JedisPoolConfig getShardedPoolConfig() {
		return shardedPoolConfig;
	}


	/**
	 * @param shardedPoolConfig the shardedPoolConfig to set
	 */
	public void setShardedPoolConfig(JedisPoolConfig shardedPoolConfig) {
		this.shardedPoolConfig = shardedPoolConfig;
	}


	/**
	 * @return the shards
	 */
	public List<JedisShardInfo> getShards() {
		return shards;
	}


	/**
	 * @param shards the shards to set
	 */
	public void setShards(List<JedisShardInfo> shards) {
		this.shards = shards;
	}


	@Override
	public DataAccessException translateExceptionIfPossible(RuntimeException runtimeexception) {
		return JedisUtils.convertJedisAccessException(runtimeexception);
	}


}
