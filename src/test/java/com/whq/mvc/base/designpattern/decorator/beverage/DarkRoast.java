package com.whq.mvc.base.designpattern.decorator.beverage;

import com.whq.mvc.base.designpattern.decorator.AbstractBeverage;

/**
 * @Description: 焦炒咖啡DarkRoast
 * @Author: whq
 * @Date: 2021/8/23 16:13
 */
public class DarkRoast extends AbstractBeverage {

    public DarkRoast() {
        setDescription("焦炒咖啡DarkRoast");
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
