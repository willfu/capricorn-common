/**
 * Sohu.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.caishi.capricorn.common.lock;

import java.io.IOException;

/**
 *
 * @author yeyanchao
 */
public class LockTest {


    public static void main(String[] args) throws InterruptedException, IOException {
        LockTest.testMem();
//        LockTest.testCustom();
    }

    public static void testRedisLocker() throws InterruptedException {
//        Locker lock = new RedisLocker();
//        for(;;){
//            System.out.println(lock.tryLock("LockTest"));
//            Thread.sleep(1000);
//        }
    }

    public static void testMem() throws IOException {
//        //10.13.81.74:30003
//        InetSocketAddress address = new InetSocketAddress("10.13.81.74",30003);
//        net.spy.smc.memcached.MemcachedClient client = new net.spy.smc.memcached.MemcachedClient(address);
//
//        for(;;){
//            try{
//                System.out.println("Task !");
//                new DistributedLock(new MemcachedLocker(client)).execute(new DistributedLock.Task<Object>() {
//                    @Override
//                    public Object run() {
//                        System.out.println("I am here");
//                        return null;
//                    }
//                }, "LockTestLockTest", 4, 1000, 4000);
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
    }

    public static void testCustom(){
//        String DEFAULT_LOCK_HOST = "10.10.76.14";
//        int DEFAULT_LOCK_PORT = 6379;
//        String DEFAULT_LOCK_PASSWD = "smcadmin";
//        for(;;){
//            try{
//                System.out.println("Task !");
//                new DistributedLock(new RedisLocker(DEFAULT_LOCK_HOST,DEFAULT_LOCK_PORT,DEFAULT_LOCK_PASSWD)).execute(new DistributedLock.Task<Object>() {
//                    @Override
//                    public Object run() {
//                        System.out.println("I am here");
//                        return null;
//                    }
//                }, "LockTestLockTest", 4, 1000, 4000);
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
    }

    public static void testDefault(){
//        for(;;){
//            try{
//                System.out.println("Task !");
//                new DistributedLock().execute(new DistributedLock.Task<Object>() {
//                    @Override
//                    public Object run() {
//                        System.out.println("I am here");
//                        return null;
//                    }
//                },"LockTestLockTest",4,1000,4000);
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
    }


}
