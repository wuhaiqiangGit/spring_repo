package com.whq.mvc.base.designpattern.adapter.objectadapter;


import com.whq.mvc.base.designpattern.adapter.Duck;
import com.whq.mvc.base.designpattern.adapter.WildTurkey;

/**
 * @Description: 类适配器 
 * @Author: whq
 * @Date: 2021/8/23 9:37
 */
public class WildTurkeyToDuckAdapter implements Duck {
    
    private final WildTurkey wildTurkey;

    public WildTurkeyToDuckAdapter(WildTurkey wildTurkey) {
        this.wildTurkey = wildTurkey;
    }

    @Override
    public void quack() {
        wildTurkey.gobble();
    }

    @Override
    public void fly() {
        wildTurkey.fastFly();
    }
}
