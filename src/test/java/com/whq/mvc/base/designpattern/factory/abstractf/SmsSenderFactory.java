package com.whq.mvc.base.designpattern.factory.abstractf;


import com.whq.mvc.base.designpattern.factory.Sender;
import com.whq.mvc.base.designpattern.factory.impl.SmsSender;

/**
 * @Description: smsSender工厂类 
 * @Author: whq
 * @Date: 2021/8/23 10:57
 */
public class SmsSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
