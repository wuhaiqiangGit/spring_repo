package com.whq.mvc.base.collection;

import org.junit.Test;

import java.util.*;

/**
 * @Description: 集合测试
 * @Author: whq
 * @Date: 2021/8/29 23:15
 */
public class ListTest {

    /**
     * @Description: 测试 list iterator和 listIterator
     * @Author: whq
     * @Date: 2021/8/29 23:24
     */
    @Test
    public void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String result = iterator.next();
            System.out.printf("result: %s\n", result);
        }
        System.out.printf("%s\n", "-------------------");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String result = listIterator.next();
            if (result.equals("c")) {
                listIterator.remove();
                listIterator.add("e");
            }
            System.out.printf("result: %s\n", result);
        }
        System.out.printf("%s\n", "-------------------");
        while (listIterator.hasPrevious()) {
            String result = listIterator.previous();
            System.out.printf("result: %s\n", result);
        }
    }

    /**
     * @Description: 测试set集合
     * @Author: whq
     * @Date: 2021/8/29 23:33
     */
    @Test
    public void testSet() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add(null);
        System.out.printf("set size: %s\n", set.size());
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String result = iterator.next();
            System.out.printf("result: %s\n", result);
        }
    }
}
