package com.whq.mvc.base.designpattern.proxy.dynamic.jdk.impl;


import com.whq.mvc.base.designpattern.proxy.dynamic.jdk.SayHello;

import java.io.Serializable;

/**
 * @Description: sayhello接口实现类
 * @Author: whq
 * @Date: 2021/8/21 16:59
 */
public class SayHelloImpl implements SayHello, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
