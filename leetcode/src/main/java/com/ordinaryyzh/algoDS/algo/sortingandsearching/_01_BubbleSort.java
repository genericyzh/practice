package com.ordinaryyzh.algoDS.algo.sortingandsearching;

/**
 * @author genericyzh
 *         冒泡排序：每次循环能让最大的数排到最后（在这个过程中大数总是往右靠），最多要经过length此循环，即可得到升序数组
 *         优化点，如果某一次遍历中没有发现可交换的数据，那么就已经是排好序了
 * @date 2017/9/25 23:23
 */
public class _01_BubbleSort {

    public static <T extends Comparable> void sort(T[] a) {
        if (a == null) {
            return;
        }
        boolean sorted = true; // true：已排序  false：未排序
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1].compareTo(a[j]) > 0) {
                    T temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }

    /**
     * This is simple version of in-place, stable bubble sort, whose best case is O(n) and worst Case O(n^2);
     */
    public static void sortSimple(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean sorted = true; // flag to check if any swapping made
            // last elements sorted
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) { //swap
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    sorted = false;
                }
            }
            // if any swapping has not occurred in the last iteration, we can say it is sorted now
            if (sorted) break;
        }
    }

    public static void main(String[] args) {

        Integer[] integers = {34, 21, 54, 18, 23, 76, 38, 98, 45, 33, 27, 51, 11, 20, 79,
                30, 89, 41};

        long start = System.currentTimeMillis();

        sort(integers);// 冒泡排序

        System.out.println("所用时间：" + (System.currentTimeMillis() - start));
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
        }

        int[] p = {34, 21, 54, 18, 23, 76, 38, 98, 45, 33, 27, 51, 11, 20, 79,
                30, 89, 41};

        start = System.currentTimeMillis();

        sortSimple(p);// 冒泡排序

        System.out.println("\n所用时间：" + (System.currentTimeMillis() - start));
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
    }

}
