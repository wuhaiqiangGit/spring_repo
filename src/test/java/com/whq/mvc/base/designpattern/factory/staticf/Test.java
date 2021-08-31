package com.whq.mvc.base.designpattern.factory.staticf;


import com.whq.mvc.base.designpattern.factory.Sender;

/**
 * @Description: 测试类
 * @Author: whq
 * @Date: 2021/8/23 10:53
 */
public class Test {
    public static void main(String[] args) {
        Sender mailSender = SendFactory.produce("mail");
        mailSender.send();
        Sender smsSender = SendFactory.produce("sms");
        smsSender.send();
    }
}
