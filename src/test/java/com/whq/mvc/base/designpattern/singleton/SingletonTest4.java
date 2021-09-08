package com.whq.mvc.base.designpattern.singleton;

/** 
 * @Description: 静态内部类信息，满足了线程安全，也满足了懒加载
 * @Author: whq
 * @Date: 2021/9/8 15:22
 */
public class SingletonTest4 {

    private static class SingletonHolder {
        private static final SingletonTest4 instance = new SingletonTest4();
    }

    private SingletonTest4() {
    }

    public static SingletonTest4 getInstance() {
        return SingletonHolder.instance;
    }
}
