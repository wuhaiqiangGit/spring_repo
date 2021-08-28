package com.whq.mvc.base.algorithm;

import org.junit.Test;

/**
 * @Description: 选择排序算法
 * @Author: whq
 * @Date: 2021/8/28 10:07
 */
public class SelectionSortTest {

    @Test
    public void testSort() {
        int[] arrays = {1, 5, 2, 7, 9, 10, 6, 3, 8};
        printArrays(arrays);
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[minIndex]){
                    minIndex = j;   //将最小值的index保存
                }
            }
            if (i != minIndex){
                int temp = arrays[i];
                arrays[i] = arrays[minIndex];
                arrays[minIndex] = temp;
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
