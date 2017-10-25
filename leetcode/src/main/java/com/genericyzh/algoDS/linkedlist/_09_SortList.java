package com.genericyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 合并两个已排序的单向链表
 * <p>
 * 这里拓展一下，写一下单向链表的归并排序
 *
 * @author genericyzh
 * @date 2017/8/16 22:32 2017/10/25
 */
public class _09_SortList {

    /**
     * 归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode start = slow.next;
        slow.next = null;

        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(start);
        return mergeTwoLists(leftNode, rightNode);
    }

    /**
     * 递归写法
     *
     * @param l1
     * @param l2
     * @return
     */
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
     * 非递归写法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                dummy.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                dummy.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = listNode5;
        listNode5.next = listNode4;

        /**
         * 1 3 2 5 4
         */
        _09_SortList sortList = new _09_SortList();
        ListNode head = sortList.sortList(listNode1);
        printLinkedList(head);
    }

    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }
}
