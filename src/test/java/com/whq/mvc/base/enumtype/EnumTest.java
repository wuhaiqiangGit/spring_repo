package com.whq.mvc.base.enumtype;

import org.junit.Test;

/**
 * @Description: 枚举类测试
 * 1.枚举类是继承 Enum类的，而且是final修饰的，所以不能被继承
 * 2.枚举类的构造方法是私有的，不能直接new枚举类对象
 * 3.枚举类的值都是 public static final修饰的
 * 4.compareTo方法比较的是ordinal的值，也就是定义的顺序值，从0开始
 * 5.枚举类不能继承，因为默认继承了Enum类，但是可以实现接口
 * @Author: whq
 * @Date: 2021/8/29 10:33
 */
public class EnumTest {

    /**
     * @Description: 枚举类测试
     * @Author: whq
     * @Date: 2021/8/28 22:41
     */
    @Test
    public void testEnum() {
        WeekEnum monday = WeekEnum.MONDAY;
        WeekEnum friday = WeekEnum.FRIDAY;
        System.out.printf("monday : %s\n", monday.name());
        for (WeekEnum weekEnum : WeekEnum.values()) {
            System.out.printf("%s:%s\n", weekEnum.name(), weekEnum.getData());
        }

        System.out.printf("ordinal: %s\n", WeekEnum.valueOf("MONDAY"));
    }

    /** 
     * @Description: 测试switch 
     * @Author: whq
     * @Date: 2021/8/29 10:47
     */
    @Test
    public void testEnumSwitch() {
        WeekEnum weekEnum = WeekEnum.MONDAY;
        switch (weekEnum) {
            case MONDAY:
                System.out.printf("%s\n", "周一");
                break;
            case TUESDAY:
                System.out.printf("%s\n", "周二");
                break;
            case WEDNESDAY:
                System.out.printf("%s\n", "周三");
                break;
            case THURSDAY:
                System.out.printf("%s\n", "周四");
                break;
            case FRIDAY:
                System.out.printf("%s\n","周五");
                break;
            case SATURDAY:
                System.out.printf("%s\n","周六");
                break;
            case SUNDAY:
                System.out.printf("%s\n","周日");
                break;
            default:
        }
    }
}
