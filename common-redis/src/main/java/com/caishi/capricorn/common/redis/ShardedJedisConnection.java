package com.caishi.capricorn.common.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.connection.jedis.JedisVersionUtil;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.types.RedisClientInfo;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;

/**
 * redis分区连接类，不知道选择dbIndex，不支持keys操作，不支持无key的方法
 *
 * Created by apple on 15/7/6.
 */
public class ShardedJedisConnection implements RedisConnection {


	private static final String charsetName = "utf-8";
	protected final ShardedJedis shardedJedis;
	protected final redis.clients.util.Pool<ShardedJedis> shardedPool;
	/**
	 * flag indicating whether the sharded connection needs to be dropped or not
	 */
	protected volatile boolean broken = false;

	/**
	 * @return the broken
	 */
	public boolean isBroken() {
		return broken;
	}

	/**
	 * @param broken the broken to set
	 */
	public void setBroken(boolean broken) {
		this.broken = broken;
	}


	/**
	 * Constructs a new <code>ShardJedisConnection</code> instance backed by a ShardRedis pool.
	 *
	 * @param shardedJedis
	 * @param pool         can be null, if no pool is used
	 */
	public ShardedJedisConnection(ShardedJedis shardedJedis, redis.clients.util.Pool<ShardedJedis> pool) {
		this.shardedJedis = shardedJedis;
		this.shardedPool = pool;
	}

	protected DataAccessException convertJedisAccessException(Exception ex) {
		broken = true;
		if (ex instanceof JedisException) {
			return JedisUtils.convertJedisAccessException((JedisException) ex);
		}
		return new RedisSystemException("Unknown jedis exception", ex);
	}


	public void close() throws DataAccessException {
		// return the connection to the pool
		try {
			if (shardedPool != null) {
				if (broken) {
					shardedPool.returnBrokenResource(shardedJedis);
				} else {
					shardedPool.returnResource(shardedJedis);
				}
			}
		} catch (Exception ex) {
			shardedPool.returnBrokenResource(shardedJedis);
		}
	}


	public ShardedJedis getNativeConnection() {
		return shardedJedis;
	}

	public void disconnect() {
		try {
			shardedJedis.disconnect();
		} catch (Exception e) {
			throw convertJedisAccessException(e);
		}
	}


	public Long del(byte[]... keys) {
		try {
			Long result = 0L;
			for (byte[] bs : keys) {
				result += shardedJedis.del(new String(bs, charsetName));
			}
			return result;
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean exists(byte[] key) {
		try {
			return shardedJedis.exists(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean expire(byte[] key, long seconds) {
		try {
			return (shardedJedis.expire(key, (int) seconds) == 1);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Set time to live for given {@code key} in milliseconds.
	 * <p/>
	 * See http://redis.io/commands/pexpire
	 *
	 * @param key
	 * @param millis
	 * @return
	 */
	@Override
	public Boolean pExpire(byte[] key, long millis) {
		try {
			return (shardedJedis.expire(key, (int)millis/1000) == 1);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean expireAt(byte[] key, long unixTime) {
		try {
			return (shardedJedis.expireAt(key, unixTime) == 1);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Set the expiration for given {@code key} as a {@literal UNIX} timestamp in milliseconds.
	 * <p/>
	 * See http://redis.io/commands/pexpireat
	 *
	 * @param key
	 * @param unixTimeInMillis
	 * @return
	 */
	@Override
	public Boolean pExpireAt(byte[] key, long unixTimeInMillis) {
		try {
			return (shardedJedis.expireAt(key, unixTimeInMillis/1000) == 1);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long ttl(byte[] key) {
		try {
			return shardedJedis.ttl(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Get the time to live for {@code key} in milliseconds.
	 * <p/>
	 * See http://redis.io/commands/pttl
	 * <p/>
	 * jedis 2.7.2 版本不支持该操作
	 *
	 * @param key
	 * @return
	 */
	@Override
	public Long pTtl(byte[] key) {
		throw new UnsupportedOperationException();
	}


	public DataType type(byte[] key) {
		try {
			return DataType.fromCode(shardedJedis.type(key));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	public byte[] get(byte[] key) {
		try {
			return shardedJedis.get(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public void set(byte[] key, byte[] value) {
		try {
			shardedJedis.set(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] getSet(byte[] key, byte[] value) {
		try {
			return shardedJedis.getSet(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long append(byte[] key, byte[] value) {
		try {
			return shardedJedis.append(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public void setEx(byte[] key, long time, byte[] value) {
		try {
			shardedJedis.setex(key, (int) time, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Set the {@code value} and expiration in {@code milliseconds} for {@code key}.
	 * <p/>
	 * See http://redis.io/commands/psetex
	 * <p/>
	 * jedis 2.7.2 版本不支持该操作
	 *
	 * @param key
	 * @param milliseconds
	 * @param value
	 * @since 1.3
	 */
	@Override
	public void pSetEx(byte[] key, long milliseconds, byte[] value) {
		throw new UnsupportedOperationException();
	}


	public Boolean setNX(byte[] key, byte[] value) {
		try {
			Long code = (shardedJedis.setnx(key, value));
			return (code != null ? code.intValue() == 1 : null);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] getRange(byte[] key, long start, long end) {
		try {
			return shardedJedis.substr(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long decr(byte[] key) {
		try {
			return shardedJedis.decr(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long decrBy(byte[] key, long value) {
		try {
			return shardedJedis.decrBy(key, (int) value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long incr(byte[] key) {
		try {
			return shardedJedis.incr(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long incrBy(byte[] key, long value) {
		try {
			return shardedJedis.incrBy(key, (int) value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Increment value of {@code key} by {@code value}.
	 * <p/>
	 * See http://redis.io/commands/incrbyfloat
	 * <p/>
	 * jedis 2.7.2 版本不支持该操作
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public Double incrBy(byte[] key, double value) {
		throw new UnsupportedOperationException();
	}


	public void setRange(byte[] key, byte[] value, long start) {
		try {
			if (isQueueing()) {
				throw new UnsupportedOperationException();
			}
			if (isPipelined()) {
				throw new UnsupportedOperationException();
			}
			shardedJedis.setrange(new String(key, charsetName), start, new String(value, charsetName));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long lPush(byte[] key, byte[] value) {
		try {
			return shardedJedis.lpush(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long rPush(byte[] key, byte[] value) {
		try {
			return shardedJedis.rpush(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] lIndex(byte[] key, long index) {
		try {
			return shardedJedis.lindex(key, (int) index);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long lInsert(byte[] key, Position where, byte[] pivot, byte[] value) {
		LIST_POSITION position = Position.AFTER.equals(where) ? LIST_POSITION.AFTER : LIST_POSITION.BEFORE;
		try {
			return shardedJedis.linsert(key, position, pivot, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long lLen(byte[] key) {
		try {
			return shardedJedis.llen(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] lPop(byte[] key) {
		try {
			return shardedJedis.lpop(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public List<byte[]> lRange(byte[] key, long start, long end) {
		try {
			return shardedJedis.lrange(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long lRem(byte[] key, long count, byte[] value) {
		try {
			return shardedJedis.lrem(key, (int) count, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public void lSet(byte[] key, long index, byte[] value) {
		try {
			shardedJedis.lset(key, (int) index, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public void lTrim(byte[] key, long start, long end) {
		try {
			shardedJedis.ltrim(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] rPop(byte[] key) {
		try {
			return shardedJedis.rpop(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean sAdd(byte[] key, byte[] value) {
		try {
			return (shardedJedis.sadd(key, value) == 1);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	/**
	 * Add given {@code values} to set at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/sadd
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long sAdd(byte[] key, byte[]... values) {
		try {
			return shardedJedis.sadd(key, values);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long sCard(byte[] key) {
		try {
			return shardedJedis.scard(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean sIsMember(byte[] key, byte[] value) {
		try {
			return shardedJedis.sismember(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> sMembers(byte[] key) {
		try {
			return shardedJedis.smembers(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	public byte[] sPop(byte[] key) {
		try {
			return shardedJedis.spop(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public byte[] sRandMember(byte[] key) {
		try {
			return shardedJedis.srandmember(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Get {@code count} random elements from set at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/srandmember
	 *
	 * @param key
	 * @param count
	 * @return
	 */
	@Override
	public List<byte[]> sRandMember(byte[] key, long count) {
		try {
			return shardedJedis.srandmember(key, (int) count);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Use a {@link Cursor} to iterate over elements in set at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/scan
	 *
	 * @param key
	 * @param options
	 * @return
	 * @since 1.4
	 */
	@Override
	public Cursor<byte[]> sScan(byte[] key, ScanOptions options) {
		return null;
	}


	public Boolean sRem(byte[] key, byte[] value) {
		Number code = null;
		try {
			code = (shardedJedis.srem(key, value));
			return (code != null ? code.intValue() == 1 : null);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	/**
	 * Remove given {@code values} from set at {@code key} and return the number of removed elements.
	 * <p/>
	 * See http://redis.io/commands/srem
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long sRem(byte[] key, byte[]... values) {
		Long code = null;
		try {
			code = shardedJedis.srem(key, values);
			return code;
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean zAdd(byte[] key, double score, byte[] value) {
		Number code = null;
		try {
			code = shardedJedis.zadd(key, score, value);
			return (code != null ? code.intValue() == 1 : null);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Add {@code tuples} to a sorted set at {@code key}, or update its {@code score} if it already exists.
	 * <p/>
	 * See http://redis.io/commands/zadd
	 *
	 * @param key
	 * @param tuples
	 * @return
	 */
	@Override
	public Long zAdd(byte[] key, Set<Tuple> tuples) {
		Long code = null;
		Map<byte[], Double> args = zAddArgs(tuples);
		try {
			code = shardedJedis.zadd(key, args);
			return code;
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	private Map<byte[], Double> zAddArgs(Set<Tuple> tuples) {

		Map<byte[], Double> args = new LinkedHashMap<byte[], Double>(tuples.size(), 1);
		Set<Double> scores = new HashSet<Double>(tuples.size(), 1);

		boolean isAtLeastJedis24 = JedisVersionUtil.atLeastJedis24();

		for (Tuple tuple : tuples) {

			if (!isAtLeastJedis24) {
				if (scores.contains(tuple.getScore())) {
					throw new UnsupportedOperationException(
							"Bulk add of multiple elements with the same score is not supported. Add the elements individually.");
				}
				scores.add(tuple.getScore());
			}

			args.put(tuple.getValue(), tuple.getScore());
		}

		return args;
	}

	public Long zCard(byte[] key) {
		try {
			return shardedJedis.zcard(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long zCount(byte[] key, double min, double max) {
		try {
			return shardedJedis.zcount(key, min, max);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Double zIncrBy(byte[] key, double increment, byte[] value) {
		try {
			return shardedJedis.zincrby(key, increment, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRange(byte[] key, long start, long end) {
		try {
			return shardedJedis.zrange(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRangeWithScores(byte[] key, long start, long end) {
		try {
			return MyJedisUtils.convertJedisTuple(shardedJedis.zrangeWithScores(key, (int) start, (int) end));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRangeByScore(byte[] key, double min, double max) {
		try {
			return shardedJedis.zrangeByScore(key, min, max);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRangeByScoreWithScores(byte[] key, double min, double max) {
		try {
			return MyJedisUtils.convertJedisTuple(shardedJedis.zrangeByScoreWithScores(key, min, max));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRevRangeWithScores(byte[] key, long start, long end) {
		try {
			return MyJedisUtils.convertJedisTuple(shardedJedis.zrevrangeWithScores(key, (int) start, (int) end));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRangeByScore(byte[] key, double min, double max, long offset, long count) {
		try {
			return shardedJedis.zrangeByScore(key, min, max, (int) offset, (int) count);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRangeByScoreWithScores(byte[] key, double min, double max, long offset, long count) {
		try {
			return MyJedisUtils.convertJedisTuple(shardedJedis.zrangeByScoreWithScores(key, min, max, (int) offset, (int) count));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRevRangeByScore(byte[] key, double min, double max, long offset, long count) {
		try {
			if (isQueueing()) {
				throw new UnsupportedOperationException();
			}
			if (isPipelined()) {
				throw new UnsupportedOperationException();
			}
			throw new UnsupportedOperationException();
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRevRangeByScore(byte[] key, double min, double max) {
		try {
			if (isQueueing()) {
				throw new UnsupportedOperationException();
			}
			if (isPipelined()) {
				throw new UnsupportedOperationException();
			}
			throw new UnsupportedOperationException();
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, double min, double max, long offset, long count) {
		try {
			if (isQueueing()) {
				throw new UnsupportedOperationException();
			}
			if (isPipelined()) {
				throw new UnsupportedOperationException();
			}
			throw new UnsupportedOperationException();
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<Tuple> zRevRangeByScoreWithScores(byte[] key, double min, double max) {
		try {
			if (isQueueing()) {
				throw new UnsupportedOperationException();
			}
			if (isPipelined()) {
				throw new UnsupportedOperationException();
			}
			throw new UnsupportedOperationException();
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long zRank(byte[] key, byte[] value) {
		try {
			return shardedJedis.zrank(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	/**
	 * Remove {@code values} from sorted set. Return number of removed elements.
	 * <p/>
	 * See http://redis.io/commands/zrem
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long zRem(byte[] key, byte[]... values) {
		try {
			return shardedJedis.zrem(key, values);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean zRem(byte[] key, byte[] value) {
		try {
			return MyJedisUtils.convertCodeReply(shardedJedis.zrem(key, value));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long zRemRange(byte[] key, long start, long end) {
		try {
			return shardedJedis.zremrangeByRank(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long zRemRangeByScore(byte[] key, double min, double max) {
		try {
			return shardedJedis.zremrangeByScore(key, min, max);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> zRevRange(byte[] key, long start, long end) {
		try {
			return shardedJedis.zrevrange(key, (int) start, (int) end);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long zRevRank(byte[] key, byte[] value) {
		try {
			return shardedJedis.zrevrank(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Double zScore(byte[] key, byte[] value) {
		try {
			return shardedJedis.zscore(key, value);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean hSet(byte[] key, byte[] field, byte[] value) {
		try {
			return MyJedisUtils.convertCodeReply(shardedJedis.hset(key, field, value));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean hSetNX(byte[] key, byte[] field, byte[] value) {
		try {
			return MyJedisUtils.convertCodeReply(shardedJedis.hsetnx(key, field, value));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean hDel(byte[] key, byte[] field) {
		try {
			return MyJedisUtils.convertCodeReply(shardedJedis.hdel(key, field));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Delete given hash {@code fields}.
	 * <p/>
	 * See http://redis.io/commands/hdel
	 *
	 * @param key
	 * @param fields
	 * @return
	 */
	@Override
	public Long hDel(byte[] key, byte[]... fields) {
		try {
			return shardedJedis.hdel(key, fields);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Boolean hExists(byte[] key, byte[] field) {
		try {
			return shardedJedis.hexists(key, field);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	public byte[] hGet(byte[] key, byte[] field) {
		try {
			return shardedJedis.hget(key, field);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Map<byte[], byte[]> hGetAll(byte[] key) {
		try {
			return shardedJedis.hgetAll(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Use a {@link Cursor} to iterate over entries in hash at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/scan
	 *
	 * @param key
	 * @param options
	 * @return
	 * @since 1.4
	 */
	@Override
	public Cursor<Map.Entry<byte[], byte[]>> hScan(byte[] key, ScanOptions options) {
		throw new UnsupportedOperationException();
	}

	public Long hIncrBy(byte[] key, byte[] field, long delta) {
		try {
			return shardedJedis.hincrBy(key, field, (int) delta);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Increment {@code value} of a hash {@code field} by the given {@code delta}.
	 * <p/>
	 * See http://redis.io/commands/hincrbyfloat
	 *
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 */
	@Override
	public Double hIncrBy(byte[] key, byte[] field, double delta) {
		try {
			return shardedJedis.hincrByFloat(key, field, delta);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Set<byte[]> hKeys(byte[] key) {
		try {
			return shardedJedis.hkeys(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public Long hLen(byte[] key) {
		try {
			return shardedJedis.hlen(key);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public List<byte[]> hMGet(byte[] key, byte[]... fields) {
		try {
			return shardedJedis.hmget(key, fields);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public void hMSet(byte[] key, Map<byte[], byte[]> tuple) {
		try {
			shardedJedis.hmset(key, tuple);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}


	public List<byte[]> hVals(byte[] key) {
		try {
			return new ArrayList<byte[]>(shardedJedis.hvals(key));
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Adds given {@literal values} to the HyperLogLog stored at given {@literal key}.
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long pfAdd(byte[] key, byte[]... values) {
		try {
			return shardedJedis.pfadd(key, values);
		} catch (Exception ex) {
			throw convertJedisAccessException(ex);
		}
	}

	/**
	 * Return the approximated cardinality of the structures observed by the HyperLogLog at {@literal key(s)}.
	 *
	 * @param keys
	 * @return
	 */
	@Override
	public Long pfCount(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Merge N different HyperLogLogs at {@literal sourceKeys} into a single {@literal destinationKey}.
	 *
	 * @param destinationKey
	 * @param sourceKeys
	 */
	@Override
	public void pfMerge(byte[] destinationKey, byte[]... sourceKeys) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Flush lua script cache.
	 * <p/>
	 * See http://redis.io/commands/script-flush
	 */
	@Override
	public void scriptFlush() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Kill current lua script execution.
	 * <p/>
	 * See http://redis.io/commands/script-kill
	 */
	@Override
	public void scriptKill() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Load lua script into scripts cache, without executing it.<br>
	 * Execute the script by calling {@link # evalSha(String, ReturnType, int, byte[])}.
	 * <p/>
	 * See http://redis.io/commands/script-load
	 *
	 * @param script
	 * @return
	 */
	@Override
	public String scriptLoad(byte[] script) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Check if given {@code scriptShas} exist in script cache.
	 * <p/>
	 * See http://redis.io/commands/script-exits
	 *
	 * @param scriptShas
	 * @return one entry per given scriptSha in returned list.
	 */
	@Override
	public List<Boolean> scriptExists(String... scriptShas) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Evaluate given {@code script}.
	 * <p/>
	 * See http://redis.io/commands/eval
	 *
	 * @param script
	 * @param returnType
	 * @param numKeys
	 * @param keysAndArgs
	 * @return
	 */
	@Override
	public <T> T eval(byte[] script, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Evaluate given {@code scriptSha}.
	 * <p/>
	 * See http://redis.io/commands/evalsha
	 *
	 * @param scriptSha
	 * @param returnType
	 * @param numKeys
	 * @param keysAndArgs
	 * @return
	 */
	@Override
	public <T> T evalSha(String scriptSha, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Evaluate given {@code scriptSha}.
	 * <p/>
	 * See http://redis.io/commands/evalsha
	 *
	 * @param scriptSha
	 * @param returnType
	 * @param numKeys
	 * @param keysAndArgs
	 * @return
	 * @since 1.5
	 */
	@Override
	public <T> T evalSha(byte[] scriptSha, ReturnType returnType, int numKeys, byte[]... keysAndArgs) {
		throw new UnsupportedOperationException();
	}


	protected static final class MyJedisUtils {
		static Set<Tuple> convertJedisTuple(Set<redis.clients.jedis.Tuple> tuples) {
			Set<Tuple> value = new LinkedHashSet<Tuple>(tuples.size());
			for (redis.clients.jedis.Tuple tuple : tuples) {
				value.add(new DefaultTuple(tuple.getBinaryElement(), tuple.getScore()));
			}

			return value;
		}

		static Boolean convertCodeReply(Number code) {
			return (code != null ? code.intValue() == 1 : null);
		}
	}


	/*****
	 * 以下操作在分布式redis不支持
	 *********/


	@Override
	public Set<byte[]> keys(byte[] pattern) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Use a {@link Cursor} to iterate over keys.
	 * <p/>
	 * See http://redis.io/commands/scan
	 *
	 * @param options
	 * @return
	 * @since 1.4
	 */
	@Override
	public Cursor<byte[]> scan(ScanOptions options) {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte[] randomKey() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void rename(byte[] oldName, byte[] newName) {
		throw new UnsupportedOperationException();

	}

	@Deprecated
	@Override
	public Boolean renameNX(byte[] oldName, byte[] newName) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Boolean persist(byte[] key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean move(byte[] key, int dbIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<byte[]> sort(byte[] key, SortParameters params) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long sort(byte[] key, SortParameters params, byte[] storeKey) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieve serialized version of the value stored at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/dump
	 *
	 * @param key
	 * @return
	 */
	@Override
	public byte[] dump(byte[] key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Create {@code key} using the {@code serializedValue}, previously obtained using {@link #dump(byte[])}.
	 * <p/>
	 * See http://redis.io/commands/restore
	 *
	 * @param key
	 * @param ttlInMillis
	 * @param serializedValue
	 */
	@Override
	public void restore(byte[] key, long ttlInMillis, byte[] serializedValue) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public List<byte[]> mGet(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void mSet(Map<byte[], byte[]> tuple) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Boolean mSetNX(Map<byte[], byte[]> tuple) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Boolean getBit(byte[] key, long offset) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Boolean setBit(byte[] key, long offset, boolean value) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Count the number of set bits (population counting) in value stored at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/bitcount
	 *
	 * @param key
	 * @return
	 */
	@Override
	public Long bitCount(byte[] key) {
		return null;
	}

	/**
	 * Count the number of set bits (population counting) of value stored at {@code key} between {@code begin} and
	 * {@code end}.
	 * <p/>
	 * See http://redis.io/commands/bitcount
	 *
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 */
	@Override
	public Long bitCount(byte[] key, long begin, long end) {
		return null;
	}

	/**
	 * Perform bitwise operations between strings.
	 * <p/>
	 * See http://redis.io/commands/bitop
	 *
	 * @param op
	 * @param destination
	 * @param keys
	 * @return
	 */
	@Override
	public Long bitOp(BitOperation op, byte[] destination, byte[]... keys) {
		return null;
	}

	@Deprecated
	@Override
	public Long strLen(byte[] key) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Append {@code values} to {@code key}.
	 * <p/>
	 * See http://redis.io/commands/rpush
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long rPush(byte[] key, byte[]... values) {
		return null;
	}

	/**
	 * Prepend {@code values} to {@code key}.
	 * <p/>
	 * See http://redis.io/commands/lpush
	 *
	 * @param key
	 * @param values
	 * @return
	 */
	@Override
	public Long lPush(byte[] key, byte[]... values) {
		return null;
	}

	@Deprecated
	@Override
	public Long rPushX(byte[] key, byte[] value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long lPushX(byte[] key, byte[] value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<byte[]> bLPop(int timeout, byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public List<byte[]> bRPop(int timeout, byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public byte[] rPopLPush(byte[] srcKey, byte[] dstKey) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public byte[] bRPopLPush(int timeout, byte[] srcKey, byte[] dstKey) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Boolean sMove(byte[] srcKey, byte[] destKey, byte[] value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<byte[]> sInter(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 不支持操作
	 */
	@Deprecated
	@Override
	public Long sInterStore(byte[] destKey, byte[]... keys) {
		return 0L;
	}

	/**
	 * 不支持操作
	 */
	@Deprecated
	@Override
	public Set<byte[]> sUnion(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 不支持操作
	 */
	@Deprecated
	@Override
	public Long sUnionStore(byte[] destKey, byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Set<byte[]> sDiff(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long sDiffStore(byte[] destKey, byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long zUnionStore(byte[] destKey, byte[]... sets) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long zUnionStore(byte[] destKey, Aggregate aggregate, int[] weights, byte[]... sets) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long zInterStore(byte[] destKey, byte[]... sets) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long zInterStore(byte[] destKey, Aggregate aggregate, int[] weights, byte[]... sets) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Use a {@link Cursor} to iterate over elements in sorted set at {@code key}.
	 * <p/>
	 * See http://redis.io/commands/scan
	 *
	 * @param key
	 * @param options
	 * @return
	 * @since 1.4
	 */
	@Override
	public Cursor<Tuple> zScan(byte[] key, ScanOptions options) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Get elements where score is between {@code min} and {@code max} from sorted set.
	 * <p/>
	 * See http://redis.io/commands/zrangebyscore
	 *
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 * @since 1.5
	 */
	@Override
	public Set<byte[]> zRangeByScore(byte[] key, String min, String max) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Get elements in range from {@code begin} to {@code end} where score is between {@code min} and {@code max} from
	 * sorted set.
	 * <p/>
	 * See http://redis.io/commands/zrangebyscore
	 *
	 * @param key
	 * @param min
	 * @param max
	 * @param offset
	 * @param count
	 * @return
	 * @since 1.5
	 */
	@Override
	public Set<byte[]> zRangeByScore(byte[] key, String min, String max, long offset, long count) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void multi() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public List<Object> exec() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void discard() {
		throw new UnsupportedOperationException();

	}

	@Deprecated
	@Override
	public void watch(byte[]... keys) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void unwatch() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSubscribed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Subscription getSubscription() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Long publish(byte[] channel, byte[] message) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void subscribe(MessageListener listener, byte[]... channels) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void pSubscribe(MessageListener listener, byte[]... patterns) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void select(int dbIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public byte[] echo(byte[] message) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public String ping() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void bgWriteAof() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Start an {@literal Append Only File} rewrite process on server.
	 * <p/>
	 * See http://redis.io/commands/bgrewriteaof
	 *
	 * @since 1.3
	 */
	@Override
	public void bgReWriteAof() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void bgSave() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long lastSave() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void save() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Long dbSize() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void flushDb() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void flushAll() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Properties info() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Load server information for given {@code selection}.
	 * <p/>
	 * See http://redis.io/commands/info
	 *
	 * @param section
	 * @return
	 */
	@Override
	public Properties info(String section) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void shutdown() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Shutdown server.
	 * <p/>
	 * See http://redis.io/commands/shutdown
	 *
	 * @param option
	 * @since 1.3
	 */
	@Override
	public void shutdown(ShutdownOption option) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public List<String> getConfig(String pattern) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void setConfig(String param, String value) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public void resetConfigStats() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Request server timestamp using {@code TIME} command.
	 *
	 * @return current server time in milliseconds.
	 * @since 1.1
	 */
	@Override
	public Long time() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Closes a given client connection identified by {@literal host:port}.
	 *
	 * @param host of connection to close.
	 * @param port of connection to close
	 * @since 1.3
	 */
	@Override
	public void killClient(String host, int port) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Assign given name to current connection.
	 *
	 * @param name
	 * @since 1.3
	 */
	@Override
	public void setClientName(byte[] name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the name of the current connection.
	 * <p/>
	 * See http://redis.io/commands/client-getname
	 *
	 * @return
	 * @since 1.3
	 */
	@Override
	public String getClientName() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Request information and statistics about connected clients.
	 * <p/>
	 * See http://redis.io/commands/client-list
	 *
	 * @return {@link List} of {@link RedisClientInfo} objects.
	 * @since 1.3
	 */
	@Override
	public List<RedisClientInfo> getClientList() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Change redis replication setting to new master.
	 * <p/>
	 * See http://redis.io/commands/slaveof
	 *
	 * @param host
	 * @param port
	 * @since 1.3
	 */
	@Override
	public void slaveOf(String host, int port) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Change server into master.
	 * <p/>
	 * See http://redis.io/commands/slaveof
	 *
	 * @since 1.3
	 */
	@Override
	public void slaveOfNoOne() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isClosed() {
		return false;
	}

	/**
	 * 非pipeline
	 */
	@Override
	public boolean isQueueing() {
		return false;
	}

	/**
	 * 非pipeline
	 */
	@Override
	public boolean isPipelined() {
		return false;
	}

	@Deprecated
	@Override
	public void openPipeline() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public List<Object> closePipeline() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return
	 * @since 1.4
	 */
	@Override
	public RedisSentinelConnection getSentinelConnection() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Override
	public Object execute(String command, byte[]... args) {
		throw new UnsupportedOperationException();
	}


}
