package com.whq.mvc.base.algorithm;

import org.junit.Test;

/**
 * @Description: 冒泡排序
 * @Author: whq
 * @Date: 2021/8/24 16:23
 */
public class BubbleSortTest {

    @Test
    public void testSort() {
        int[] arrays = {1, 5, 2, 7, 9, 10, 6, 3, 8};
        printArrays(arrays);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j+1] = temp;
                }
            }
        }
        printArrays(arrays);
    }


    private final void printArrays(int[] arrays) {
        System.out.println("数组：");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + ((i < arrays.length - 1) ? "," : ""));
        }
        System.out.println();
    }

}
