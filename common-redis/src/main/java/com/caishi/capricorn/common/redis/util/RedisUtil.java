package com.caishi.capricorn.common.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

public class RedisUtil {

    private RedisUtil() {

    }


    public final static <T> T getMessageSummaryKey(ShardedJedis shardedJedis, String key, Class<T> clazz) {
        T result = null;
        String val = shardedJedis.get(key);
        if (val != null && val.length() > 0) {

        }
        return result;
    }

    public final static <T> T getMessageSummaryKey(Jedis jedis, String key, Class<T> clazz) {
        T result = null;
        String val = jedis.get(key);
        if (val != null && val.length() > 0) {

        }
        return result;
    }
}