package com.ordinaryyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 * 将一个单向链表翻转，2种做法：1、非递归 2、递归
 *
 * @author genericyzh
 * @date 2017/8/2 23:06
 */
public class _05_ReverseLinkedList {

    /**
     * 非递归写法（修改顺序从左到右）
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归写法:得到倒数第二个元素后直接操作即可，返回最后一个元素为链表头（修改顺序从右到左）
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // case1: empty list
        if (head == null) {
            return head;
        }
        // case2: only one element list
        if (head.next == null) {
            return head;
        }
        // case3: reverse from the rest after head
        ListNode newHead = reverseList2(head.next);
        // reverse between head and head->next
        head.next.next = head;
        // unlink list from the rest
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode head = listNode1;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        _05_ReverseLinkedList reverseLinkedList = new _05_ReverseLinkedList();
//        ListNode listNode = reverseLinkedList.reverseList(listNode1);
        ListNode listNode = reverseLinkedList.reverseList2(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
