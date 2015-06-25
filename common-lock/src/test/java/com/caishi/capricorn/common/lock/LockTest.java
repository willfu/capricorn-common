/**
 * Sohu.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.caishi.capricorn.common.lock;

import com.caishi.capricorn.common.lock.locker.Locker;
import com.caishi.capricorn.common.lock.locker.impl.MemcachedLocker;
import com.caishi.capricorn.common.lock.locker.impl.RedisLocker;
import com.caishi.capricorn.common.lock.locker.impl.ShardRedisLocker;
import net.spy.memcached.MemcachedClient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yeyanchao
 */
public class LockTest {


	public static void main(String[] args) throws InterruptedException, IOException {
//		LockTest.testRedisLocker();
//		LockTest.testShardedRedisLocker();
		LockTest.testMemLocker();
	}

	public static void testRedisLocker() throws InterruptedException {
		JedisPool pool = new JedisPool("10.10.1.54", 6379);
		Locker lock = new RedisLocker(pool, 1000);
		final DistributedLock distributedLock = new DistributedLock(lock);
		testDistributedLock(distributedLock);

		System.out.printf("%n%n");
	}

	public static void testShardedRedisLocker() throws InterruptedException {
		List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
		shardInfoList.add(new JedisShardInfo("10.10.1.54", 6379));
		shardInfoList.add(new JedisShardInfo("10.10.1.54", 6380));
		ShardedJedisPool shardedJedis = new ShardedJedisPool(new GenericObjectPoolConfig(),shardInfoList);
		ShardRedisLocker shardRedisLocker = new ShardRedisLocker(shardedJedis,1000);
		final DistributedLock distributedLock = new DistributedLock(shardRedisLocker);
		testDistributedLock(distributedLock);
		System.out.printf("%n%n");
	}


	public static void testMemLocker() throws IOException, InterruptedException {
		InetSocketAddress address = new InetSocketAddress("10.10.1.54",11211);
		MemcachedClient client = new MemcachedClient(address);

		MemcachedLocker locker = new MemcachedLocker(client,1000);

		DistributedLock distributedLock = new DistributedLock(locker);
		testDistributedLock(distributedLock);

		System.out.printf("%n%n");
//		client.shutdown();
	}


	private static void testDistributedLock(final DistributedLock distributedLock) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		final CountDownLatch latch = new CountDownLatch(1);

		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					latch.await();
					System.out.println(Thread.currentThread().getId() + " try to get lock..");
					distributedLock.execute(new Task<Void>() {
						@Override
						public Void run() {
							try {
								System.out.println(Thread.currentThread().getId() + " has got lock...");
								TimeUnit.MILLISECONDS.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							return null;
						}
					}, "lock123",2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};


		executorService.submit(task);

		executorService.submit(task);

		latch.countDown();

		TimeUnit.SECONDS.sleep(1);
		executorService.shutdown();
	}


}
