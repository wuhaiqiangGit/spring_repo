package com.whq.mvc.base.designpattern.singleton;

/**
 * @Description: 饿汉式创建单例对象，但是是非懒加载的，也就是一开始就初始化对象
 * @Author: whq
 * @Date: 2021/9/8 15:09
 */
public class SingletonTest3 {

    private static final SingletonTest3 instance = new SingletonTest3();

    private SingletonTest3() {
    }

    public static SingletonTest3 getInstance() {
        return instance;
    }
}
