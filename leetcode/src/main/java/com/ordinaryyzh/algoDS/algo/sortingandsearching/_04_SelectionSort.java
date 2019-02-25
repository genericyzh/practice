package com.ordinaryyzh.algoDS.algo.sortingandsearching;

import java.util.Arrays;

/**
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72912
 * 选择排序:核心：不断地选择剩余元素中的最小者。
 * <p>
 * 找到数组中最小元素并将其和数组第一个元素交换位置。
 * 在剩下的元素中找到最小元素并将其与数组第二个元素交换，直至整个数组排序。
 * 性质：
 * 比较次数=(N-1)+(N-2)+(N-3)+...+2+1~N^2/2
 * 交换次数=N
 * 运行时间与输入无关
 * 数据移动最少
 *
 * @author OrdinaryYZH
 * @date 2017/9/28 21:46
 */
public class _04_SelectionSort {

    public static void selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.println(Arrays.toString(array));
            int min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }

    public static <T extends Comparable> void sort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) // find min
                if (a[minIndex].compareTo(a[j]) > 0)
                    minIndex = j;

            if (minIndex != i) { // swap
                T temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int unsortedArray[] = new int[]{9,8,7,6,5,4,3,2,1};
        int unsortedArray[] = new int[]{8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
        selectionSort(unsortedArray);
        System.out.println("After sort: ");
        System.out.println(Arrays.toString(unsortedArray));
    }

}
