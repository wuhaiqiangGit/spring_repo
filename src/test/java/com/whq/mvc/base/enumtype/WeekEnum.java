package com.whq.mvc.base.enumtype;

import java.math.BigDecimal;

public enum  WeekEnum {
    MONDAY("周一"){
        @Override
        public double calculate(double v1, double v2) {
            BigDecimal b1 = new BigDecimal(Double.toString(v1));
            BigDecimal b2 = new BigDecimal(Double.toString(v2));
            return b1.add(b2).doubleValue();
        }
    };

    private String data;

    WeekEnum(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public abstract double calculate(double v1,double v2);
}
