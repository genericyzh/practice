package com.genericyzh.algoDS.linkedlist;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 给出k个已排序的链表，合并成一个
 * 参考：https://github.com/billryan/algorithm-exercise/blob/master/zh-hans/linked_list/merge_k_sorted_lists.md
 * 第二种解法如果是这种情况的话，浪费了太多的时间：
 * 第1个链表：1-10000
 * 第2个链表：10001
 * 第3个链表：10002
 * 第k个链表：10000+k
 * 每次都要跟第一个链表全部比较一次，再插到最后
 * 所以有了第三种解法
 *
 * @author genericyzh
 * @date 2017/8/24 0:00 2017/10/28
 */
public class _11_MergekSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        return sort(lists, 0, lists.length - 1);
    }

    ListNode sort(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftNode = sort(lists, left, mid);
        ListNode rightNode = sort(lists, mid + 1, right);
        return mergeTwoLists(leftNode, rightNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 非递归归写法
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode merge(ListNode left, ListNode right) {
        ListNode x = new ListNode(0);
        ListNode xx = x;
        while (left != null || right != null) {
            if (left == null) {
                x.next = right;
                break;
            } else if (right == null) {
                x.next = left;
                break;
            } else {
                if (left.val < right.val) {
                    x.next = left;
                    left = left.next;
                } else {
                    x.next = right;
                    right = right.next;
                }
            }
            x = x.next;
        }
        return xx.next;
    }

}
