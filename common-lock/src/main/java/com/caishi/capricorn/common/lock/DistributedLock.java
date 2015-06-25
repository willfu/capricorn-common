/**
 * Sohu.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.caishi.capricorn.common.lock;

import com.caishi.capricorn.common.lock.locker.Locker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

/**
 *
 * @author yeyanchao
 */
public class DistributedLock {

    private static Logger log = LoggerFactory.getLogger(DistributedLock.class);

    public Locker locker;

    public DistributedLock(Locker locker) {
        this.locker = locker;
    }

    public DistributedLock setLocker(Locker locker) {
        this.locker = locker;
        return this;
    }

    class NotFetchLockException extends RuntimeException {
        private static final long serialVersionUID = -6490056205468921965L;

        public NotFetchLockException(String message) {
            super(message);
        }

    }

    public <E> E execute(Task<E> task, String id) throws InterruptedException, NotFetchLockException {
        return execute(task, id, 10, 50L, 1);
    }

    public <E> E execute(Task<E> task, String id, int retryCount) throws InterruptedException, NotFetchLockException {
        return execute(task, id, retryCount, 50L, 1);
    }

    public <E> E execute(Task<E> task, String id, int retryCount, int expiredTime) throws InterruptedException, NotFetchLockException {
        return execute(task, id, retryCount, 50L, expiredTime);
    }

    public <E> E execute(Task<E> task, String id, final int retryCount, long delayTime, int expiredTime) throws InterruptedException, NotFetchLockException {
        final String key = "lock:" + id;
        long getLock = 0;
        int cnt = retryCount;
        while (getLock == 0 && (retryCount == -1 || cnt-- > 0)) {
            getLock = locker.tryLock(key, expiredTime);
            if (getLock > 0) {
                try {
                    return task.run();
                } finally {
                    locker.unLock(key, getLock);
                }
            }
            Thread.sleep(delayTime);
        }
        throw new NotFetchLockException(format("not fetch lock for id=%s retryCount=%s delayTime(ms)=%s",//
          id, retryCount, delayTime)//
        );
    }

    public long getLock(int expiredTime, final String key) {
        try {
            return locker.tryLock(key, expiredTime);
        } catch (Exception e) {
            log.info("try to get Lock Exception:" + e.getMessage());
        }
        return 0;
    }
}
