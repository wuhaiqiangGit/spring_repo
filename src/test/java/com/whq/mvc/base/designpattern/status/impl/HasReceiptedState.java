package com.whq.mvc.base.designpattern.status.impl;


import com.whq.mvc.base.designpattern.status.BillState;

/**
 * @Description: 已签收状态
 * @Author: whq
 * @Date: 2021/8/22 16:36
 */
public class HasReceiptedState implements BillState {
    @Override
    public String name() {
        return "已签收状态";
    }
}
