package com.ordinaryyzh.algoDS.linkedlist;

/**
 * 142. Linked List Cycle II https://leetcode.com/problems/linked-list-cycle-ii/description/
 * 给出一个单向链表，如果有环的话，返回环的开头节点，否则返回null
 * <p>
 * 参考：http://bookshadow.com/weblog/2015/07/10/leetcode-linked-list-cycle-ii/
 *
 * @author OrdinaryYZH
 * @date 2017/8/20 18:42 2017/10/27
 */
public class _10_LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // 注意这里slow从next开始、fast从next.next开始
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode temp = head;
        while (slow != temp) {
            slow = slow.next;
            temp = temp.next;
        }
        return slow;
    }

    /**
     * 解法2，不同之处是找相交点即可( 参考：_06_IntersectionofTwoLinkedLists)，
     * 不用通过推算得出结论，slow从head开始；如果是解法1的话，slow需要从head.next开始才行
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        // 这样也可以
//        ListNode slow = head.next;
//        ListNode fast = head.next.next;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == null) {
            return null;
        }
        ListNode temp = slow.next;
        slow.next = null;// break the link
        ListNode link = findLink(head, temp);
        slow.next = temp; // link the break
        return link;
    }

    ListNode findLink(ListNode x, ListNode y) {
        if (x == null || y == null) {
            return null;
        }

        ListNode xhead = x;
        ListNode yhead = y;

        while (xhead != yhead) {
            xhead = xhead == null ? y : xhead.next;
            yhead = yhead == null ? x : yhead.next;
        }
        return xhead;
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

        _10_LinkedListCycle2 linkedListCycle = new _10_LinkedListCycle2();
        ListNode node = linkedListCycle.detectCycle2(listNode1);
//        printLinkedList(node);
        System.out.println(node);
    }


    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }
}
