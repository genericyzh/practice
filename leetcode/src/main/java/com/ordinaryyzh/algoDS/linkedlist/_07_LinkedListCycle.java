package com.ordinaryyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 题意：判断单向链表是否有环
 * 参考：https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73009
 * <p>
 * 对于带环链表的检测，效率较高且易于实现的一种方式为使用快慢指针。快指针每次走两步，慢指针每次走一步，
 * 如果快慢指针相遇(快慢指针所指内存为同一区域)则有环，否则快指针会一直走到NULL为止退出循环，返回false.
 * 快指针走到NULL退出循环即可确定此链表一定无环这个很好理解。那么带环的链表快慢指针一定会相遇吗？先来看看下图。
 * Linked List Cycle
 * <p>
 * 在有环的情况下，最终快慢指针一定都走在环内，加入第i次遍历时快指针还需要k步才能追上慢指针，由于快指针比慢指针每次多走一步。
 * 那么每遍历一次快慢指针间的间距都会减少1，直至最终相遇。故快慢指针相遇一定能确定该链表有环。
 *
 * @author genericyzh
 * @date 2017/8/8 23:49
 */
public class _07_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow.val == fast.val) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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
        listNode5.next = listNode3;

        _07_LinkedListCycle linkedListCycle = new _07_LinkedListCycle();
        boolean b = linkedListCycle.hasCycle(listNode1);
        System.out.println(b);
    }
}
