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
 * <p>
 * 所以有了第三种解法:
 * 假设总共有k个list，每个list的最大长度是n，那么运行时间满足递推式T(k) = 2T(k/2)+O(n*k)。
 * 根据主定理，可以算出算法的总复杂度是O(nklogk)。
 * 如果不了解主定理的朋友，可以参见主定理-维基百科。空间复杂度的话是递归栈的大小O(logk)。
 *
 * ★好题，要懂得：
 * 1、归并排序哦的复杂度计算
 * 2、合并操作的两种：递归、非递归实现
 *
 * @author genericyzh
 * @date 2017/8/24 0:00 2017/10/28 2017/11/08
 */
public class _11_MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return sort(lists, 0, lists.length - 1);
    }

    ListNode sort(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
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
        ListNode x = new ListNode(0); // 非递归的方式需要帮助节点，在x的基础上修改next，而不是修改left.next/right.next
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
