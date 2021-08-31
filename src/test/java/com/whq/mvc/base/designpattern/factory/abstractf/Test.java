package com.whq.mvc.base.designpattern.factory.abstractf;


import com.whq.mvc.base.designpattern.factory.Sender;

/**
 * @Description: 测试类
 * @Author: whq
 * @Date: 2021/8/23 10:57
 */
public class Test {
    public static void main(String[] args) {
        Provider mailSenderFactory = new MailSenderFactory();
        Sender mailSender = mailSenderFactory.produce();
        mailSender.send();

        Provider smsSenderFactory = new SmsSenderFactory();
        Sender smsSender = smsSenderFactory.produce();
        smsSender.send();
    }
}
