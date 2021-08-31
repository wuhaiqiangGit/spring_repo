package com.whq.mvc.base.designpattern.factory.abstractf;


import com.whq.mvc.base.designpattern.factory.Sender;

/**
 * @Description: 抽象工厂接口 
 * @Author: whq
 * @Date: 2021/8/23 10:55
 */
public interface Provider {
    Sender produce();
}
