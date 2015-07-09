package com.caishi.capricorn;

import com.caishi.capricorn.cache.core.ClientCacheManager;
import com.caishi.capricorn.cache.core.ICache;

/**
 * Created by apple on 15/7/9.
 */
public class CacheTest {

	/**
	 * cache name:
	 * cache size:
	 * cache expire time:
	 */
	private static final ICache<Integer, String> testCache = ClientCacheManager.getInstance().getCache("classifyChannelInfo", 50000, Long.MAX_VALUE);

	public static ICache<Integer, String> getTestCache() {
		return testCache;
	}


	public static void main(String[] args) {
		ICache<Integer, String> testCache = CacheTest.getTestCache();
		testCache.put(1, "hello ehcache.");

		System.out.println(testCache.get(1));

	}

}
