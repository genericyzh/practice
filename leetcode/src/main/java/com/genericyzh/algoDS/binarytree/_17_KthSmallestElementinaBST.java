package com.genericyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * 给出一个二叉搜索树，找出kth smallest节点（如果BST经常被修改(插入/删除操作),你需要找到k最小频繁吗?你会如何优化kthSmallest常规?）
 * 由二叉搜索树的定义跟题目所求值，可以很容易的得出中序遍历即可
 *
 * @author genericyzh
 * @date 2017/9/14 23:13
 */
public class _17_KthSmallestElementinaBST {

    /**
     * 解法一：中序遍历，借助两个属性
     */
    private int result;
    private int cnt;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        cnt--;
        if (cnt == 0) {
            result = node.val;
            return;
        }
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    /**
     * 更简单的写法
     */
    int ct;

    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) return -1;
        int res = kthSmallest(root.left, k);
        if (ct == k) return res;
        ct++;
        if (ct == k) return root.val;
        return kthSmallest(root.right, k);
    }

    /**
     * 解法2，非递归
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest3(TreeNode root, int k) {
        int cnt = k;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null) {
            stack.offer(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode last = stack.pollLast();
            cnt--;
            if (cnt == 0) {
                return last.val;
            }
            last = last.right;
            while (last != null) {
                stack.offer(last);
                last = last.left;
            }
        }
        return -1;
    }
}
