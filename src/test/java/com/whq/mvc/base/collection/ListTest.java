package com.whq.mvc.base.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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

    /**
     * @Description: 这里需要定义包装类型的数组
     * @Author: whq
     * @Date: 2021/9/24 12:33
     */
    @Test
    public void testArrays() throws InterruptedException {
        Integer[] array = {1, 2, 3};
        List list = Arrays.asList(array);
        System.out.printf("list size: %s\n", list.size());
        TimeUnit.SECONDS.sleep(160);
    }

    @Test
    public void testRemoveExists() {
        List<Integer> list = Arrays.asList(1, 3, 5, 2, 1, 6, 7, 3, 4, 5, 7, 8, 9, 10, 4, 5, 8, 9);
        list = new ArrayList<>(list);
        System.out.printf("list size = %s\n", list.size());
        System.out.println("---------------------");

        List<Integer> result = null;

        //stream去重
        result = list.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(i < result.size() - 1 ? "%s " : "%s\n", result.get(i));
        }
        System.out.printf("result size = %s\n", result.size());
        System.out.println("---------------------");
        result.clear();

        //set去重
        HashSet<Integer> set = new HashSet<>(list);
        result.addAll(set);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(i < result.size() - 1 ? "%s " : "%s\n", result.get(i));
        }
        System.out.printf("result size = %s\n", result.size());
        System.out.println("---------------------");
        result.clear();

        //遍历去重
        for (int i = 0; i < list.size(); i++) {
            if (result.contains(list.get(i))) {
                continue;
            }
            result.add(list.get(i));
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(i < result.size() - 1 ? "%s " : "%s\n", result.get(i));
        }
        System.out.printf("result size = %s\n", result.size());
        System.out.println("---------------------");
        result.clear();

        //遍历去重
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        result.addAll(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf(i < result.size() - 1 ? "%s " : "%s\n", result.get(i));
        }
        System.out.printf("result size = %s\n", result.size());
        System.out.println("---------------------");
        result.clear();
    }

    @Test
    public void testListNull() {
        List<String> list = new LinkedList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.printf("list.size = %s\n", list.size());
    }
}
