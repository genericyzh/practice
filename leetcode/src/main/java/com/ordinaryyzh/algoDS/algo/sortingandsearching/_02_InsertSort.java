package com.ordinaryyzh.algoDS.algo.sortingandsearching;

/**
 * 插入排序：参考图：http://images.cnitblog.com/i/497634/201403/121755260214693.jpg
 * 最佳情况就是，数组已经是正序排列了，在这种情况下，需要进行的比较操作是 （n-1）次即可。
 * 最坏情况就是，数组是反序排列，那么此时需要进行的比较共有n(n-1)/2次
 * <p>
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72913
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

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next; // 第一次pre.next = null，所以第一次cur.next = null，断开了
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    /**
     * 希尔排序:https://zh.wikipedia.org/wiki/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F
     * 插入排序的改进
     * 注意：步长的选择有很多种
     *
     * @param arr
     */
    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
    }

    public static void main(String[] args) {
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode1 = new ListNode(1);
//
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode3;
//        listNode3.next = listNode1;

        ListNode listNode3 = new ListNode(3);
        ListNode listNode1 = new ListNode(1);

        listNode3.next = listNode1;

        _02_InsertSort insertSort = new _02_InsertSort();
        ListNode listNode = insertSort.insertionSortList(listNode3);
        while (listNode != null) {
            System.out.printf("%s\t", listNode.val);
            listNode = listNode.next;
        }
        System.out.println();

    }

}
