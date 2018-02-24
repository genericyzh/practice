package com.genericyzh.algoDS.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 * 给出一个二叉树，返回后序遍历(【左右根】)的节点val数组
 *
 * @author genericyzh
 * @date 2017/9/2 18:30
 */
public class _05_PostOrderTraversalTree {

    /**
     * 简单的递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
     * 非递归写法:
     * 用栈和集合辅助
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
        // 叶子节点时，peek.left == peek.right == null
        set.add(null);

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peekLast();
            // 当左节点和右节点都在set中，当前节点就要遍历了
            if (set.contains(peek.left) && set.contains(peek.right)) {
                // 这里才在栈中去掉
                result.add(stack.pollLast().val);
                set.add(peek);
            } else {
                if (peek.right != null) {
                    stack.offerLast(peek.right);
                }
                if (peek.left != null) {
                    stack.offerLast(peek.left);
                }
            }
        }
        return result;
    }

    /**
     * 非递归的另一种写法
     * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73027
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode prev = null;
        while (!s.empty()) {
            TreeNode curr = s.peek();
            boolean noChild = false;
            // 1、叶子节点
            if (curr.left == null && curr.right == null) {
                noChild = true;
            }
            boolean childVisited = false;
            // 2、当前节点的子节点已经访问了；
            // 它有两个节点或者一个节点，有以下情况：
            // ---- 1、只有左节点，则left == prev
            // ---- 2、有两个节点，或者只有右节点，则right == prev
            // 所以这里使用 ||
            if (prev != null && (curr.left == prev || curr.right == prev)) {
                childVisited = true;
            }

            // traverse
            if (noChild || childVisited) {
                result.add(curr.val);
                s.pop();
                prev = curr;
            } else {
                if (curr.right != null) {
                    s.push(curr.right);
                }
                if (curr.left != null) {
                    s.push(curr.left);
                }
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
    public List<Integer> postorderTraversal44(TreeNode root) {
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
