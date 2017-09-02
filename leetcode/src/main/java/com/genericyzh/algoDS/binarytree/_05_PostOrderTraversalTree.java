package com.genericyzh.algoDS.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 * 给出一个二叉树，返回后序遍历的节点val数组
 *
 * @author genericyzh
 * @date 2017/9/2 18:30
 */
public class _05_PostOrderTraversalTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 简单的递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new LinkedList<>();
        List<Integer> result = new ArrayList<>(); // 不太明白arraylist居然还快一点
        if (root == null) {
            return result;
        }

        if (root.left != null) {
            result.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(postorderTraversal(root.right));
        }
        result.add(root.val);
        return result;
    }

    /**
     * 非递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        stack.offer(root);
        set.add(null);

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peekLast();
            if (set.contains(peek.left) && set.contains(peek.right)) {
                result.add(stack.pollLast().val);
                set.add(peek);
            } else {
                if (peek.right != null)
                    stack.offerLast(peek.right);
                if (peek.left != null)
                    stack.offerLast(peek.left);
            }
        }
        return result;
    }

    /**
     * 解法3，因为要返回的是【左右根】，我们可以用发现先序遍历的时候可以做到【根右左】，所以再把它reverse一下就得到答案了
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollLast();
            result.add(treeNode.val);

            if (treeNode.left != null) {
                stack.offerLast(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.offerLast(treeNode.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
