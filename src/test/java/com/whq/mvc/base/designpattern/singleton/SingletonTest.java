package com.whq.mvc.base.designpattern.singleton;

/**
 * @Description: 懒汉式 线程不安全
 * @Author: whq
 * @Date: 2021/9/8 8:34
 */
public class SingletonTest {

    private static SingletonTest instance;

    private SingletonTest() {
    }

    //懒加载，但是线程不安全
    public static SingletonTest getInstance() {
        if (null == instance) {
            instance = new SingletonTest();
        }
        return instance;
    }
}
