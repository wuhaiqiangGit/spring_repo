package com.whq.mvc.base.limit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 计数器固定窗口限流
 * @Author: whq
 * @Date: 2021/9/19 16:50
 */
public class CounterLimit {

    private int windowSize; //窗口大小，毫秒
    private int limit;  //限流大小
    private AtomicInteger count;    //窗口计数器

    public CounterLimit(int windowSize, int limit) {
        this.windowSize = windowSize;
        this.limit = limit;
        count = new AtomicInteger(0);

        new Thread(() -> {
            while (true) {
                count.set(0);
                try {
                    Thread.sleep(windowSize);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean tryAcquire() {
        int newCount = count.addAndGet(1);
        if (newCount > limit) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterLimit counterLimit = new CounterLimit(2000, 30);
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (counterLimit.tryAcquire()) {
                count++;
            }
        }
        System.out.printf("first count: %s\n", count);
        Thread.sleep(2000);
        count = 0;
        for (int i = 0; i < 100; i++) {
            if (counterLimit.tryAcquire()) {
                count++;
            }
        }
        System.out.printf("second count: %s\n", count);
    }
}
