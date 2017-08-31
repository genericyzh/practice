package com.genericyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * 给出一个二叉搜索树，设计一个迭代器，包含以下两个方法：
 * 1、hasNext()：是否存在下一个节点
 * 2、next()：输出下一个节点的val（由小到大输出）
 * 典型的非递归中序遍历！
 * <p>
 * 二叉搜索树：
 * <p>
 * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 任意节点的左、右子树也分别为二叉查找树；
 * 没有键值相等的节点。
 *
 * @author genericyzh
 * @date 2017/8/31 23:43
 */
public class _04_BSTIterator {
    Deque<TreeNode> stack;
    TreeNode cur;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public _04_BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        cur = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (cur != null) {
            stack.offerLast(cur);
            cur = cur.left;
        }
        TreeNode temp = stack.pollLast();
        cur = temp.right;
        return temp.val;
    }
}
