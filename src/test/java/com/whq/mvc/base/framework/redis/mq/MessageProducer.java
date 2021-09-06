package com.whq.mvc.base.framework.redis.mq;

import redis.clients.jedis.Jedis;

/**
 * @Description: 模拟生产者
 * @Author: whq
 * @Date: 2021/9/4 18:37
 */
public class MessageProducer extends Thread {

    public static final String MESSAGE_KEY = "message:queue";
    private volatile int count;
    public Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                putMessage("message" + count);
            }
        }
    }

    private void putMessage(String message) {
        Jedis jedis = JedisPoolUtils.getJedisInstance();
        Long size = jedis.lpush(MESSAGE_KEY, message);
        System.out.printf("%s , put message , size = %s, count = %s\n", Thread.currentThread().getName(), size, count);
        count++;
    }
}
