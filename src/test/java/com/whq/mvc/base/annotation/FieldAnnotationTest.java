package com.whq.mvc.base.annotation;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Description: 自定义注解测试类
 * @Author: whq
 * @Date: 2021/8/30 23:17
 */
public class FieldAnnotationTest {

    @MyFieldAnnotation(desc = "用户名", length = 11)
    private String username;

    @Test
    public void testFieldAnnotation() {
        Class<? extends FieldAnnotationTest> aClass = this.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(MyFieldAnnotation.class)) {
                MyFieldAnnotation fieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
                String desc = fieldAnnotation.desc();
                int length = fieldAnnotation.length();
                System.out.printf("FieldName: %s desc: %s length: %s\n", field.getName(), desc, length);
            }
        }
    }
}
