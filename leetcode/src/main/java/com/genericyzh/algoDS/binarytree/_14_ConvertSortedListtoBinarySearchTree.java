package com.genericyzh.algoDS.binarytree;


/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * 给出一个升序的链表，返回一个高度平衡的搜索树
 * https://siddontang.gitbooks.io/leetcode-solution/content/tree/convert_sorted_listarray_to_binary_search_tree.html
 * 这题需要将一个排好序的链表转成一个平衡二叉树，我们知道，对于一个二叉树来说，左子树一定小于根节点，
 * 而右子树大于根节点。所以我们需要找到链表的中间节点，这个就是根节点，链表的左半部分就是左子树，
 * 而右半部分则是右子树，我们继续递归处理相应的左右部分，就能够构造出对应的二叉树了。
 * <p>
 * 这题的难点在于如何找到链表的中间节点，我们可以通过fast，slow指针来解决，fast每次走两步，slow每次走一步，fast走到结尾，那么slow就是中间节点了。
 *
 * @author genericyzh
 * @date 2017/9/10 23:39
 */
public class _14_ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return build(head, null);
    }

    private TreeNode build(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode slow = start;
        ListNode fast = start.next; // 当只有2个节点的时候，slow应该是第一个
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = build(start, slow);
        treeNode.right = build(slow.next, end);
        return treeNode;
    }
}
