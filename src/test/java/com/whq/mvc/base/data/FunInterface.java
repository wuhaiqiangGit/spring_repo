package com.whq.mvc.base.data;

/**
 * @Description: 函数式接口
 * Java8为函数式接口引入了一个新的注解@FunctionalInterface，主要用于编译级错误检查，加上该注解，
 * 当你写的接口不符合函数式接口的定义时，编译器会报错。
 *
 * 函数式接口首先必须是一个接口，接口里面只能有一个抽象方法（允许有默认方法、静态方法等）；
 * 这种类型的接口也称为SAM接口，即Single Abstract Method Interface。
 * @Author: whq
 * @Date: 2021/9/1 17:12
 */
@FunctionalInterface
public interface FunInterface {
    
    void talk(String words);

    //可以有default方法
    default void look(){}

    //也可以用static方法，但是只能有一个抽象方法
    public static void sleep(){

    }
}
