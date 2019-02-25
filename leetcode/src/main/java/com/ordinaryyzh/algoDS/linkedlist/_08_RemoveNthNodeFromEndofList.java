package com.ordinaryyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 给出一个单向链表，删除倒数第n个元素，并返回头结点
 *
 * @author OrdinaryYZH
 * @date 2017/8/9 23:45
 */
public class _08_RemoveNthNodeFromEndofList {


    /**
     * 解法1：
     * 1、得到所有元素个数
     * 2、计算要删除的正数元素是第几个
     * 3、删除
     * 注意：使用dummy
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode dummy = temp;

        int size = 0;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp = dummy;

        int i = size - n;
        while (i > 0) {
            temp = temp.next;
            i--;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }

    /**
     * 递归用到的字段
     */
    private int n;

    /**
     * 解法2：递归
     * 解法1更好理解
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        this.n = n;
        remove(head);
        return this.n == 0 ? head.next : head;
    }

    private void remove(ListNode x) {
        if (x == null) {
            return;
        }
        remove(x.next);
        if (n == 0) {
            x.next = x.next.next; // 找到时不return，如果是head被删除的话，n=0，否则n<0 || >0；当n==size时，即系要删除head时，这里是不会被执行到的
        }
        n--;
    }

    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        _08_RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new _08_RemoveNthNodeFromEndofList();
//        ListNode head = removeNthNodeFromEndofList.removeNthFromEnd(listNode1, 5);
        ListNode head = removeNthNodeFromEndofList.removeNthFromEnd2(listNode1, 2);
        printLinkedList(head);

//        ListNode listNode1 = new ListNode(1);
//        _08_RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new _08_RemoveNthNodeFromEndofList();
//        ListNode head = removeNthNodeFromEndofList.removeNthFromEnd(listNode1, 1);
//        printLinkedList(head);
    }
}
