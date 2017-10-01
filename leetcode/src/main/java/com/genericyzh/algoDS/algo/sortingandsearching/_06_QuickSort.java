package com.genericyzh.algoDS.algo.sortingandsearching;

/**
 * @author genericyzh
 * @date 2017/10/1 23:50
 */
public class _06_QuickSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);

    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = lo + (hi - lo) / 2;
        swap(a, pivot, hi);
        int storeIndex = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < a[hi]) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, hi, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort2(int[] a) {
        quickSort2(a, 0, a.length - 1);
    }

    /**
     * 优化交换次数
     */
    public static void quickSort2(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[start]; // 最好的pivot是取中值，现在这种取法非常不科学
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] >= pivot) {
                right--;
            }
            if (left > right) break;
            // swap array[left] with array[right] while left <= right
            swap(arr, start, end);
        }
        /* swap the smaller with pivot */
        swap(arr, pivot, right);

        quickSort2(arr, start, right - 1);
        quickSort2(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        int unsortedArray2[] = new int[]{4, 4, 3, 3, 8, 8, 2, 2, 6, 6, 1, 1, 7, 7, 5};
//        sort2(unsortedArray);
        sort(unsortedArray2);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}