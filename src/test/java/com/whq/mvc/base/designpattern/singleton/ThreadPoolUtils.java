package com.whq.mvc.base.designpattern.singleton;

import java.util.concurrent.*;

/**
 * @Description: 线程池单例工具类
 * @Author: whq
 * @Date: 2021/9/8 15:21
 */
public class ThreadPoolUtils {

    private static ThreadPoolExecutor executor;

    //可用处理器的java虚拟机的数量
    private static int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static int corePoolSize = 2;
    private static int maximumPoolSize = 6;
    private static int keepAliveTime = 1;
    private static TimeUnit timeUnit = TimeUnit.DAYS;
    private static int capacity = 50000;
    private static LinkedBlockingQueue<Runnable> queue;

    private ThreadPoolUtils() {
    }

    private static class ThreadPoolHolder {
        private static final ThreadPoolUtils instance = new ThreadPoolUtils();
    }

    private ThreadPoolExecutor init() {
        if (null == executor) {
            queue = new LinkedBlockingQueue<>(capacity);
            executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, queue);
        }
        return executor;
    }

    public static ThreadPoolUtils getInstance() {
        ThreadPoolUtils instance = ThreadPoolHolder.instance;
        instance.init();
        return instance;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getPoolSize() {
        return executor.getPoolSize();
    }

    public boolean isQueueFull() {
        return queue.size() == capacity;
    }

    public boolean isBusy() {
        return getPoolSize() == maximumPoolSize && isQueueFull();
    }

    public Future<?> submit(Callable callable) {
        return executor.submit(callable);
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        int taskSize = 20;
        CountDownLatch latch = new CountDownLatch(taskSize);
        ThreadPoolUtils poolUtils = ThreadPoolUtils.getInstance();
        for (int i = 0; i < taskSize; i++) {
            poolUtils.execute(() -> {
                System.out.printf("%s\n", Thread.currentThread().getName());
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("队列是否繁忙-->" + poolUtils.isBusy());
        System.out.println("队列是否满员-->" + poolUtils.isQueueFull());
        System.out.println("线程池数量-->" + poolUtils.getPoolSize());
        System.out.println("线程池队列数量-->" + poolUtils.getQueueSize());
        poolUtils.shutdown();//一般不用关闭线程池,这里只是为了示例效果
    }
}

