package com.whq.mvc.base.framework.redis.mq;

/**
 * @Description: 模拟 mq消费者
 * @Author: whq
 * @Date: 2021/9/4 18:31
 */
public class MessageConsumer extends Thread {

    public static final String MESSAGE_KEY = "message:queue";



    @Override
    public void run() {
        super.run();
    }
}
