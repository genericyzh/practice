package com.ordinaryyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * 给出两个单向链表，他们有可能后面部分完全重合，找出重合的节点
 * A:          a1 → a2
 * ****************** ↘
 * ****************** c1 → c2 → c3
 * ****************** ↗
 * B:     b1 → b2 → b3
 *
 * @author genericyzh
 * @date 2017/8/7 0:19
 */
public class _06_IntersectionofTwoLinkedLists {

    /**
     * 解法1：简单暴力...
     * 1、先要知道两个链表的长度
     * 2、以短的链表为首，长的先"跳到"跟短的一样长先
     * 3、一一对比
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int sizeA = getLinkedListSize(headA);
        int sizeB = getLinkedListSize(headB);
        int dif = Math.abs(sizeA - sizeB);

        if (sizeA > sizeB) {
            while (dif > 0) {
                headA = headA.next;
                dif--;
            }
        } else {
            while (dif > 0) {
                headB = headB.next;
                dif--;
            }
        }

        while (headA != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLinkedListSize(ListNode listNode) {
        int size = 0;
        while (listNode != null) {
            size++;
            listNode = listNode.next;
        }
        return size;
    }

    /**
     * 解法2：
     * 一种不需要知道链表长度的做法，
     * 用两个指针分别指向两个头，当遍历完一个链表时，跳到另一个，当长的一个遍历完跳到另一个时，短的一个也就刚好可以跟长的"靠右对齐"
     * 达到跟解法1一样的效果，接着一个个对比即可
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        // 能够处理无交点的情况
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        /**
         * 1 -> 2 -> 3 -> 5 -> 6 -> 7
         */
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        /**
         * 4 -> 5 -> 6 ->7
         */
        ListNode listNodeB = new ListNode(4);
        listNodeB.next = listNode5;

        ListNode listNodeC = new ListNode(8);

        _06_IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new _06_IntersectionofTwoLinkedLists();
//        System.out.println(intersectionofTwoLinkedLists.getIntersectionNode(listNode1, listNodeB));
//        System.out.println(intersectionofTwoLinkedLists.getIntersectionNode2(listNode1, listNodeB));
        System.out.println(intersectionofTwoLinkedLists.getIntersectionNode2(listNode1, listNodeC));
    }
}
