/**
 * Sohu.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.caishi.capricorn.common.lock.locker.impl;

import com.caishi.capricorn.common.lock.locker.Locker;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Future;

/**
 * 基于Memcached的分布式锁
 * @author yeyanchao
 */
public class MemcachedLocker implements Locker {

	static class MemClient {

		private MemcachedClient client;

		public MemClient(MemcachedClient client) {
			this.client = client;
		}

		public Object get(String key) {
			return client.get(key);
		}

		public boolean add(String key, int exp, Object value) {
			boolean result = false;
			try{
				Future<Boolean> future = client.add(key, exp, value);
				result = future.get().booleanValue();
			}catch (Exception e){
				//TODO
			}
			return result;
		}

		public void del(String key) {
			Future<Boolean> future = client.delete(key);
		}

	}

	private MemClient cache;
	private long timeOut;

	public MemcachedLocker(MemcachedClient cache, long timeOut) {
		this.cache = new MemClient(cache);
		this.timeOut = timeOut;
	}

	@Override
	public long tryLock(String key) {
		return tryLock(key, timeOut);
	}

	@Override
	public long tryLock(String key, long lockTimeOut) {
		//得到锁后设置的过期时间，未得到锁返回0
		long expireTime = 0;
		expireTime = System.currentTimeMillis() + lockTimeOut + 1;
		int timeOut = (int) Math.round(lockTimeOut / 1000.0);
		if (cache.add(key, timeOut, String.valueOf(expireTime)) == true) {
			//得到了锁返回
			return expireTime;
		} else {
			return 0;
		}
	}

	@Override
	public void unLock(String key, long lockExpireTime) {
		if (System.currentTimeMillis() - lockExpireTime > 0) {
			return;
		}
		String curLockTimeStr = (String) cache.get(key);
		if (StringUtils.isNotBlank(curLockTimeStr) && Long.valueOf(curLockTimeStr) > System.currentTimeMillis()) {
			cache.del(key);
		}
	}

	@Override
	public Locker setTimeOut(long expireTime) {
		this.timeOut = expireTime;
		return this;
	}
}
