package com.whq.mvc.base.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义注解 默认都会继承java.lang.annotation.Annotation 类
 * 标准的元注解：
 *   @Target： 是专门用来限定某个自定义注解能够被应用在哪些Java元素上面的，标明作用范围；
 *      取值在java.lang.annotation.ElementType 中进行定义的。
 *   @Retention： 翻译为持久力、保持力。即用来修饰自定义注解的生命周期。
 *     注解的生命周期有三个阶段：
 *      Java源文件阶段；
 *      编译到class文件阶段；
 *      运行期阶段；
 *      取值在java.lang.annotation.RetentionPolicy 中进行定义的。
 *      SOURCE: 注解将被编译器忽略
 *      CLASS: 注解将被编译器记录在class文件中，但是运行时不会被虚拟机保留，是一个默认行为
 *      RUNTIME: 注解将被编译器记录在class文件中，而且在运行时会被虚拟机保留，因此可以通过反射读取到
 *   @Documented： 用来指定自定义注解是否能随着被定义的java文件生成到JavaDoc文档当中。
 *   @Inherited： 指定某个自定义注解如果写在了父类的声明部分，那么子类的声明部分也能自动拥有该注解。
 *      只对那些@Target被定义为 ElementType.TYPE 的自定义注解起作用。
 *
 * @Author: whq
 * @Date: 2021/8/30 22:28
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFieldAnnotation {

    String desc();

    int length();
}
