package com.whq.mvc.base.designpattern.factory.impl;


import com.whq.mvc.base.designpattern.factory.Sender;

/**
 * @Description: 短信发送
 * @Author: whq
 * @Date: 2021/8/23 10:48
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("使用短信发送信息");
    }
}
