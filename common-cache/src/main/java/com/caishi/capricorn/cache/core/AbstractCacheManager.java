package com.caishi.capricorn.cache.core;

import net.sf.ehcache.CacheManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 优先使用抽象类去获取CacheManager实例
 */
public abstract class AbstractCacheManager {

	protected Map<Object, ICache> cacheMap = new HashMap<Object, ICache>();

	protected CacheManager manager = new CacheManager();

	public static AbstractCacheManager getInstance() {
		return ClientCacheManager.getInstance();
	}

	/**
	 * @param cacheName
	 * @return
	 */
	public abstract <K, V> ICache<K, V> getCache(String cacheName);

	/**
	 * @param cacheName
	 * @param maxSize
	 * @param leftTime
	 * @return
	 */
	public abstract <K, V> ICache<K, V> getCache(String cacheName, int maxSize, long leftTime);

}
