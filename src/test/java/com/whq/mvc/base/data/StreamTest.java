package com.whq.mvc.base.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description: Stream类测试
 * @Author: whq
 * @Date: 2021/9/1 20:34
 */
public class StreamTest {

    @Test
    public void testStream() {
        List<Integer> list = Arrays.asList(1, 3, 7, 10, 5, 8, 9, 2);
        //遍历符合输入条件的元素
        //list.stream().filter(x -> x > 4).forEach(System.out::println);
        //匹配第一个符合条件的元素
        Optional<Integer> first = list.stream().filter(x -> x > 4).findFirst();
        //匹配随机一个
        Optional<Integer> any = list.stream().filter(x -> x > 4).findAny();
        //是否有符合条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 10);
        System.out.printf("first: %s\n",first.get());
        System.out.printf("any: %s\n",any.get());
        System.out.printf("anyMatch: %s\n",anyMatch);
    }
}
