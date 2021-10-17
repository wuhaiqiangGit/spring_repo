package com.whq.mvc.base.data;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @Description: 基本数据类型测试
 * @Author: whq
 * @Date: 2021/8/28 10:46
 */
public class DataTypeTest {

    /**
     * @Description: 测试浮点数类型
     * @Author: whq
     * @Date: 2021/8/28 10:46
     */
    @Test
    public void testFloatAndDouble() {
        float a = 0.121F;
        float b = 0.03F;
        System.out.printf("a*b = %s\n", a * b);

        double c = 1.11D;
        double d = 1.11D;

        BigDecimal cb = new BigDecimal(Double.toString(c));
        BigDecimal cd = new BigDecimal(Double.toString(d));


        System.out.printf("c*d = %s\n", cb.add(cd).doubleValue());
        System.out.printf("c == d %s\n", cb.compareTo(cd) == 0);
    }

    @Test
    public void testArithmeticUtils() {
        double r1 = ArithmeticUtils.add(1.29, 1.09);
        System.out.printf("r1:1.29 + 1.09 = %s\n", r1);
        BigDecimal r2 = ArithmeticUtils.add("1.1", "2.2");
        System.out.printf("r2:1.1 + 2.2 = %s\n", r2.toString());
        String r3 = ArithmeticUtils.add("1.111", "2.224", 2);
        System.out.printf("r3:1.111 + 2.224 = %s\n", r3);

        double r4 = ArithmeticUtils.sub(2.22, 1.1);
        System.out.printf("r4:2.22 - 1.1 = %s\n", r4);
        BigDecimal r5 = ArithmeticUtils.sub("2.3", "1.01");
        System.out.printf("r5:2.3 - 1.01 = %s\n", r5.doubleValue());
        String r6 = ArithmeticUtils.sub("1.89", "0.12", 1);
        System.out.printf("r6:1.89 - 0.12 = %s\n", r6);

        double r7 = ArithmeticUtils.mul(1.1, 2.2);
        System.out.printf("r7:1.1 * 2.2 = %s\n", r7);
        BigDecimal r8 = ArithmeticUtils.mul("1.2", "1.3");
        System.out.printf("r8:1.2 * 1.3 = %s\n", r8.toString());
        double r9 = ArithmeticUtils.mul("1.23", "2.13", 3);
        System.out.printf("r9:1.23 * 2.13 = %s\n", r9);

        double r10 = ArithmeticUtils.div(1.3, 0.3);
        System.out.printf("r10:1.3 / 0.3 = %s\n", r10);
        String r11 = ArithmeticUtils.div("1.23", "0.33", 5);
        System.out.printf("r11:1.23 / 0.33 = %s\n", r11);

        double r12 = ArithmeticUtils.round(1.23456, 3);
        System.out.printf("r12: 1.23456 round(3) = %s\n", r12);
        String r13 = ArithmeticUtils.round("1.23456", 4);
        System.out.printf("r13: 1.23456 round(4) = %s\n", r13);

        double r14 = ArithmeticUtils.remainder(5, 2, 2);
        System.out.printf("r14: = %s\n", r14);

        boolean r15 = ArithmeticUtils.compare("2.2", "1.1");
        System.out.printf("r15: 2.2 >= 1.1 %s\n", r15);
    }


    @Test
    public void testConstantPool() {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "Hel";
        String s8 = "lo";
        String s9 = s7 + s8;

        System.out.printf("s1 == s2 %s\n", s1 == s2);   //  true
        System.out.printf("s1 == s3 %s\n", s1 == s3);   //  true    这种情况编译器会进行优化，s3等同于Hello了
        System.out.printf("s1 == s4 %s\n", s1 == s4);   //  false
        System.out.printf("s1 == s9 %s\n", s1 == s9);   //  false   虽然s7和s8都是字符串，但是s9需要通过计算，只有在运行时才在堆里面计算出了结果，所以地址是未知的
        System.out.printf("s4 == s5 %s\n", s4 == s5);   //  false
        System.out.printf("s1 == s6 %s\n", s1 == s6);   //  true    intern后加入了常量池，所以相等
    }

    @Test
    public void testInt() {
        double i = 1.8d;
        i = Math.round(i);
        int j = (int) i;
        System.out.printf("j= %s\n", j);

        Random random = new Random(10);
        for (int k = 0; k < 100; k++) {
            int randomInt = random.nextInt(10) + 10;
            System.out.printf("randomInt: %s\n", randomInt);
        }
    }

}
