package com.whq.mvc.base.enumtype;

/** 
 * @Description: 星期枚举类 
 * @Author: whq
 * @Date: 2021/8/29 10:39
 */
public enum  WeekEnum {
    MONDAY("周一"),TUESDAY("周二"),WEDNESDAY("周三"),
    THURSDAY("周四"),FRIDAY("周五"),SATURDAY("周六"),SUNDAY("周日");

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
}
