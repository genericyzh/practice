package com.genericyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * 给出一个二叉树，返回前缀数组
 *
 * @author genericyzh
 * @date 2017/9/2 23:09
 */
public class _06_BinaryTreePreorderTraversal {

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    /**
     * 非递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.offerLast(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.offerLast(treeNode.left);
            }
        }
        return result;
    }
}
