package com.whq.mvc.base.generictype;

import java.util.List;

/**
 * @Description: 简单泛型类
 * @Author: whq
 * @Date: 2021/8/29 16:51
 */
public class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void getInfo(List<? extends Number> obj){
        System.out.printf("obj: %s\n",obj);
    }
}
