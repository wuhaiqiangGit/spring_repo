package com.whq.mvc.base.data;

import org.junit.Test;

import java.util.Optional;

/**
 * @Description: optional类测试
 * @Author: whq
 * @Date: 2021/9/1 20:34
 */
public class OptionalTest {

    @Test
    public void testOptional() {
        //参数不能是null
        Optional<Integer> optionalInteger = Optional.of(1);
        Optional<Integer> optionalInteger1 = Optional.ofNullable(12);
        optionalInteger1.ifPresent(obj -> {
            System.out.printf("%s\n", obj);
        });
        Optional<Integer> filterInteger = optionalInteger.filter(x -> {
            return x > 0;
        });
        System.out.printf("filterInteger: %s\n", filterInteger.get());

        Optional<Integer> mapInteger = optionalInteger.map(x -> {
            return x + 1;
        });
        System.out.printf("mapInteger: %s\n", mapInteger.get());

        Optional<Integer> flatMapInteger = optionalInteger.flatMap(x -> {
            return Optional.<Integer>ofNullable(x + 1);
        });
        System.out.printf("flatMapInteger: %s\n", flatMapInteger.get());
    }
}
