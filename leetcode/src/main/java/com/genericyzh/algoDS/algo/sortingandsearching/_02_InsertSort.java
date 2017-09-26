package com.genericyzh.algoDS.algo.sortingandsearching;

/**
 * 插入排序：参考图：http://images.cnitblog.com/i/497634/201403/121755260214693.jpg
 * 最佳情况就是，数组已经是正序排列了，在这种情况下，需要进行的比较操作是 （n-1）次即可。
 * 最坏情况就是，数组是反序排列，那么此时需要进行的比较共有n(n-1)/2次
 *
 * @author genericyzh
 * @date 2017/9/26 23:43
 */
public class _02_InsertSort {

    public static void sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > currentNumber) { // 因为i左边都是已经排好序的，所以如果numbers[j] > currentNumber不成立，则可以跳出循环
                numbers[j + 1] = numbers[j]; // 向后移动一位
                j--;
            }
            numbers[j + 1] = currentNumber;
        }
    }

    public static <T extends Comparable> void sort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            T current = a[i];

            while (j > 0 && a[j - 1].compareTo(current) > 0) {
                a[j] = a[--j];
            }

            if (j != i)
                a[j] = current;
        }
    }

}
