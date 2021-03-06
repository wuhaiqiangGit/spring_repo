package com.whq.mvc.base.designpattern.decorator.decorator;


import com.whq.mvc.base.designpattern.decorator.AbstractBeverage;

import java.math.BigDecimal;

/**
 * @Description: 牛奶装饰 
 * @Author: whq
 * @Date: 2021/8/23 16:23
 */
public class MilkCondimentDecorator extends AbstractCondimentDecorator {

    public MilkCondimentDecorator(AbstractBeverage abstractBeverage) {
        super(abstractBeverage);
    }

    @Override
    public String getDescription() {
        //被装饰者原来的描述
        String description = abstractBeverage.getDescription();
        return description + " +牛奶milk";
    }

    @Override
    public double cost() {
        //被装饰者原来的价格
        double oldCost = abstractBeverage.cost();
        BigDecimal oldValue = new BigDecimal(Double.toString(oldCost));
        return oldValue.add(new BigDecimal("0.1")).doubleValue();
    }
}
