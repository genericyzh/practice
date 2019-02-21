package com.ordinaryyzh.algoDS.linkedlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * 给一个单向链表，判断是否是回文，最好是O(n) time and O(1) space
 * 思路：先得到链表长度，再利用递归的特性:栈中存head的next，全局存rightNode，从中间向两边判断
 *
 * @author genericyzh
 * @date 2017/8/1 22:46
 */
public class _04_PalindromeLinkedList {

    ListNode rightStart = null;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode temp = head;
        rightStart = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int start = (size - 1) / 2 + 1; // size：元素个数，要得到中间下标：(size - 1)/2，要再得到中间靠右，所以+1
        for (int i = 0; i < start; i++) {
            rightStart = rightStart.next;
        }

        return checkTwoHalves(head, size / 2);

    }

    private boolean checkTwoHalves(ListNode x, int size) {
        if (size == 1) {
            return x.val == rightStart.val;
        }
        boolean b = checkTwoHalves(x.next, size - 1);
        rightStart = rightStart.next;
        return b && x.val == rightStart.val;
    }

    /**
     * 解法2：使用快速指针遍历，同时慢指针遍历的时候把方向改变了；
     * 然后再从中间到两边对比
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast != null) { // odd
            fast = slow.next;
            slow = pre;
        } else { // even
            fast = slow;
            slow = pre;
        }

        while (fast != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        _04_PalindromeLinkedList palindromeLinkedList = new _04_PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(listNode1));

    }
}
