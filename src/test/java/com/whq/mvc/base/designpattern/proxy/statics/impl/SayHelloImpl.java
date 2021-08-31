package com.whq.mvc.base.designpattern.proxy.statics.impl;


import com.whq.mvc.base.designpattern.proxy.statics.SayHello;

/**
 * @Description:  实现类
 * @Author: whq
 * @Date: 2021/8/21 16:44
 */
public class SayHelloImpl implements SayHello {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
