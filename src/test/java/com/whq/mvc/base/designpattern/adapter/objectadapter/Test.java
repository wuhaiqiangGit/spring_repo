package com.whq.mvc.base.designpattern.adapter.objectadapter;


import com.whq.mvc.base.designpattern.adapter.Duck;
import com.whq.mvc.base.designpattern.adapter.WildTurkey;

/**
 * @Description: 测试类
 * @Author: whq
 * @Date: 2021/8/23 9:37
 */
public class Test {
    public static void main(String[] args) {
        Duck duck = new WildTurkeyToDuckAdapter(new WildTurkey());
        duck.quack();
        duck.fly();
    }
}
