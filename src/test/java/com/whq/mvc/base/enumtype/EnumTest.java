package com.whq.mvc.base.enumtype;

import org.junit.Test;

public class EnumTest {

    /**
     * @Description: 枚举类测试
     * @Author: whq
     * @Date: 2021/8/28 22:41
     */
    @Test
    public void testEnum() {
        WeekEnum monday = WeekEnum.MONDAY;
        System.out.printf("monday : %s\n",monday.calculate(1.1,2.2));
        for (WeekEnum weekEnum : WeekEnum.values()) {
            System.out.printf("%s:%s\n", weekEnum.name(),weekEnum.getData());
        }
    }
}
