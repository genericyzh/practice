package com.ordinaryyzh.algoDS.algo.sortingandsearching;

/**
 * 归并排序
 * 可参考：https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72914
 *
 * @author genericyzh
 * @date 2017/9/30 22:24
 */
public class _05_MergeSort {

    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        int[] helper = new int[a.length];
        sort(a, 0, a.length - 1, helper);
    }

    private static void sort(int[] a, int lo, int hi, int[] helper) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid, helper);
        sort(a, mid + 1, hi, helper);
        merge(a, lo, mid, hi, helper);
    }

    private static void merge(int[] a, int lo, int mid, int hi, int[] helper) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = helper[j++];
            } else if (j > hi) {
                a[k] = helper[i++];
            } else if (helper[i] <= helper[j]) {
                a[k] = helper[i++];
            } else {
                a[k] = helper[j++];
            }
        }
    }

    public static void main(String[] args) {
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        sort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
    }

}
