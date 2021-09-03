package com.whq.mvc.base.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.printf("first: %s\n", first.get());
        System.out.printf("any: %s\n", any.get());
        System.out.printf("anyMatch: %s\n", anyMatch);
    }

    @Test
    public void testTurnUpperCase() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        result.forEach(x -> System.out.printf("%s\n", x));
    }

    @Test
    public void testDistinceStream() {
        Stream<String> distinctStream = Stream.of("abcd", "abc", "ab", "a").distinct();
        Stream<String> sortedStream = distinctStream.sorted(Comparator.comparing(String::length));
        sortedStream.forEach(x -> System.out.printf("%s\n", x));
    }

    @Test
    public void testMaxSelect() {
        List<Integer> list = Arrays.asList(1, 3, 12, 4, 12, 13, 10, 99);
        Optional<Integer> min = list.stream().parallel().min(Integer::compareTo);
        Optional<Integer> max = list.stream().parallel().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.printf("min: %s max: %s\n", min.get(), max.get());
    }

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 3, 12, 4, 12, 13, 10, 99);
        Optional<Integer> count = list.stream().parallel().reduce((x, y) -> x + y);
        System.out.printf("count: %s\n", count.get());
    }
}
