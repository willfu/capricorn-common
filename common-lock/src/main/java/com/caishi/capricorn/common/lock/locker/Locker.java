/**
 * Sohu.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.caishi.capricorn.common.lock.locker;

/**
 * 分布式锁：
 * @author yeyanchao
 */
public interface Locker {

    /**
     * 尝试获取锁，使用默认的锁超时时长4s
     * @param key
     * @returns 锁过期的准确时刻
     */
    public long tryLock(String key);

    /**
     * 尝试获取锁，指定锁的超时时长
     * @param key
     * @param expireTime ms
     * @return 锁过期的准确时刻
     */
    public long tryLock(String key, long expireTime);

    /**
     * 释放锁，检查锁是否过期
     * @param key
     * @param lockExpireTime  锁过期的准确时刻
     * @return
     */
    public void unLock(String key, long lockExpireTime);

    /**
     * 设置锁的超长时长
     * @param expireTime ms
     */
    public Locker setTimeOut(long expireTime);
}
