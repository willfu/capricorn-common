package com.caishi.capricorn.common.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

public class ShardedJedisPoolFactory extends ShardedJedisPool {

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards) {
        super(poolConfig, shards);
    }

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection) {
        super(poolConfig, getJedisShardInfoList(connection));

    }

    private final static List<JedisShardInfo> getJedisShardInfoList(String connection) {
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
        String[] connectionCollection = connection.split(",");
        for (String connect : connectionCollection) {
            String[] hostInfoCollection = connect.split(":");
            if (hostInfoCollection.length == 4) {
                String host = hostInfoCollection[0];
                int port = Integer.parseInt(hostInfoCollection[1]);
                String auth = hostInfoCollection[2];
                int time = Integer.parseInt(hostInfoCollection[3]);
                JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, time, host);
                jedisShardInfo.setPassword(auth);
                jedisShardInfoList.add(jedisShardInfo);
            }
        }
        return jedisShardInfoList;
    }
}