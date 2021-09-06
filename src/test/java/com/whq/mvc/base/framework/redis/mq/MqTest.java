package com.whq.mvc.base.framework.redis.mq;

import org.junit.Test;
/**
 * @Description: 测试redis mq
 * @Author: whq
 * @Date: 2021/9/4 18:46
 */
public class MqTest {

    @Test
    public void testMq(){
        MessageProducer messageProducer = new MessageProducer();
        Thread t1 = new Thread(messageProducer);
        Thread t2 = new Thread(messageProducer);
        Thread t3 = new Thread(messageProducer);
        Thread t4 = new Thread(messageProducer);
        Thread t5 = new Thread(messageProducer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
