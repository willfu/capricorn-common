package com.caishi.capricorn.common.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.util.Base64Utils;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import java.util.ArrayList;
import java.util.List;

public class ShardedJedisPoolFactory extends ShardedJedisPool {

    private final static String noAuth = "none";

    /**
     * ShardedJedisPoolFactory Constructors
     *
     * @param poolConfig GenericObjectPoolConfig instance
     * @param shards     jedisShard Info collection
     */
    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards) {
        super(poolConfig, shards);
    }

    /**
     * ShardedJedisPoolFactory Constructors
     *
     * @param poolConfig GenericObjectPoolConfig instance
     * @param connection redis server connection string
     */
    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection) {
        super(poolConfig, getJedisShardInfoCollection(connection));

    }

    /**
     * ShardedJedisPoolFactory Constructors
     *
     * @param poolConfig GenericObjectPoolConfig instance
     * @param connection redis server connection string
     * @param timeOut    request time out (mil seconds)
     */
    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, int timeOut) {
        super(poolConfig, getJedisShardInfoCollection(connection, timeOut));
    }

    /**
     * ShardedJedisPoolFactory Constructors
     *
     * @param poolConfig GenericObjectPoolConfig instance
     * @param connection redis server connection string
     * @param auth       user auth
     */
    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, String auth) {
        super(poolConfig, getJedisShardInfoCollection(connection, auth));
    }

    /**
     * ShardedJedisPoolFactory Constructors
     *
     * @param poolConfig GenericObjectPoolConfig instance
     * @param connection redis server connection string
     * @param timeOut    request time out (mil seconds)
     * @param auth       user auth
     */
    public ShardedJedisPoolFactory(GenericObjectPoolConfig poolConfig, String connection, int timeOut, String auth) {
        super(poolConfig, getJedisShardInfoCollection(connection, timeOut, auth));
    }

    /**
     * get jedisShard Info collection
     *
     * @param connection redis server connection String
     * @return jedisShard Info collection
     */
    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection) {
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>();
        String[] hostInfoCollection = connection.split(",");
        for (String hostInfo : hostInfoCollection) {
            String[] dataSource = hostInfo.split(":");
            if (dataSource.length == 2) {
                String host = dataSource[0];
                int port = Integer.parseInt(dataSource[1]);
                String name = new String(Base64Utils.encode(host.getBytes()));
                JedisShardInfo jedisShardInfo = new JedisShardInfo(host, port, name);
                jedisShardInfoList.add(jedisShardInfo);
            }
        }
        return jedisShardInfoList;
    }

    /**
     * get jedisShard Info collection
     *
     * @param connection redis server connection String
     * @param timeOut    request time out (mil seconds)
     * @return jedisShard Info collection
     */
    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, int timeOut) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoCollection(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            jedisShardInfo.setConnectionTimeout(timeOut);
        }
        return jedisShardInfoList;
    }

    /**
     * get jedisShard Info collection
     *
     * @param connection redis server connection String
     * @param auth       user auth
     * @return jedisShard Info collection
     */
    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, String auth) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoCollection(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            if (auth != null && !auth.isEmpty() && !auth.equalsIgnoreCase(noAuth)) {
                jedisShardInfo.setPassword(auth);
            }
        }
        return jedisShardInfoList;
    }

    /**
     * get jedisShard Info collection
     *
     * @param connection redis server connection String
     * @param timeOut    request time out (mil seconds)
     * @param auth       user auth
     * @return jedisShard Info collection
     */
    private final static List<JedisShardInfo> getJedisShardInfoCollection(String connection, int timeOut, String auth) {
        List<JedisShardInfo> jedisShardInfoList = getJedisShardInfoCollection(connection);
        for (JedisShardInfo jedisShardInfo : jedisShardInfoList) {
            if (auth != null && !auth.isEmpty() && !auth.equalsIgnoreCase(noAuth)) {
                jedisShardInfo.setPassword(auth);
            }
            jedisShardInfo.setConnectionTimeout(timeOut);
        }
        return jedisShardInfoList;
    }
}