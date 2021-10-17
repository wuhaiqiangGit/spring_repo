package com.whq.mvc.base.generictype;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 泛型测试
 * @Author: whq
 * @Date: 2021/8/29 12:54
 */
public class GenericTest {

    /**
     * @Description: 泛型只在编译时有效，编译过程中，正确验证泛型结果后，会将泛型相关信息擦除，
     * 泛型信息不会进入到运行阶段
     * 通常情况下，T，E，K，V，？ 是这样约定的：
     * ？ 表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     * <p>
     * 注意：静态方法中要使用泛型，需要在方法上定义通配符，不能使用类上面定义的
     * @Author: whq
     * @Date: 2021/8/29 13:14
     */
    @Test
    public void testGenericType() {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();
        Class<? extends List> aClass = stringArrayList.getClass();
        Class<? extends List> bClass = integerArrayList.getClass();
        System.out.printf("%s\n", aClass.getSimpleName());
        Assert.assertEquals(aClass, bClass);
    }
}
