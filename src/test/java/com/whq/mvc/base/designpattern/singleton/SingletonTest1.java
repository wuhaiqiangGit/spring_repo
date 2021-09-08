package com.whq.mvc.base.designpattern.singleton;

/**
 * @Description: 懒汉式，线程安全，但是只要第一次创建对象加锁就可以，不必每次都加锁，效率不高
 * @Author: whq
 * @Date: 2021/9/8 8:36
 */
public class SingletonTest1 {

    private static SingletonTest1 instance;

    private SingletonTest1() {
    }

    public static synchronized SingletonTest1 getInstance() {
        if (null == instance) {
            instance = new SingletonTest1();
        }
        return instance;
    }
}
