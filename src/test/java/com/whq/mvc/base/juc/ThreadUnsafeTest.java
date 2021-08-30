package com.whq.mvc.base.juc;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 线程不安全实例
 * @Author: whq
 * @Date: 2021/8/30 12:51
 */
public class ThreadUnsafeTest {

    @Test
    public void testThreadUnsafe() throws InterruptedException {
        ThreadUnsafeData data = new ThreadUnsafeData();
        final int threadSize = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                data.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.printf("count: %s\n",data.getCount());
    }
}
