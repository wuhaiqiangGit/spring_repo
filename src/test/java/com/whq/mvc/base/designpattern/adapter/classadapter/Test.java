package com.whq.mvc.base.designpattern.adapter.classadapter;


import com.whq.mvc.base.designpattern.adapter.Duck;

/**
 * @Description: 测试类
 * @Author: whq
 * @Date: 2021/8/23 9:33
 */
public class Test {
    public static void main(String[] args) {
        Duck duck = new WildTurkeyToDuckAdapter();
        duck.quack();
        duck.fly();
    }
}
