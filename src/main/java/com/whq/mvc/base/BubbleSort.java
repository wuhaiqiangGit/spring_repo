package com.whq.mvc.base;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Author: whq
 * @Date: 2021/8/23 23:07
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {1,5,6,2,8,9,11,4,3,7,10};
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        printArray(array);
    }

    private static void printArray(int[] array){
        System.out.println("数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? ",":""));
        }
        System.out.println();
    }
}
