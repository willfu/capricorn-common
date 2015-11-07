package com.caishi.capricorn.common.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShardedJedisPoolFactory extends ShardedJedisPool {

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards) {
        super(poolConfig, shards);
    }

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection) {
        super(poolConfig, getJedisShardInfoList(connection));

    }

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, int timeOut) {
        super(poolConfig, getJedisShardInfoCollection(connection, timeOut));
    }

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, String auth) {
        super(poolConfig, getJedisShardInfoCollection(connection, auth));
    }

    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, int timeOut, String auth) {
        super(poolConfig, getJedisShardInfoCollection(connection, timeOut, auth));
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

    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection) {
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
        String[] hostInfoCollection = connection.split(",");
        for (String hostInfo : hostInfoCollection) {
            String[] dataSource = hostInfo.split(":");
            if (dataSource.length == 2) {
                String host = dataSource[0];
                int port = Integer.parseInt(dataSource[1]);
                JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port);
            }
        }
        return jedisShardInfoList;
    }

    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, int timeOut) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoList(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            jedisShardInfo.setTimeout(timeOut);
        }
        return jedisShardInfoList;
    }

    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, String auth) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoList(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            jedisShardInfo.setPassword(auth);
        }
        return jedisShardInfoList;
    }

    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, int timeOut, String auth) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoList(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            jedisShardInfo.setPassword(auth);
            jedisShardInfo.setTimeout(timeOut);
        }
        return jedisShardInfoList;
    }
}