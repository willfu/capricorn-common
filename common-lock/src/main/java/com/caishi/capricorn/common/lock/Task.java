package com.caishi.capricorn.common.lock;

/**
 * Created by apple on 15/6/25.
 * 分布式锁任务
 */
public interface Task<E> {
	E run();
}
