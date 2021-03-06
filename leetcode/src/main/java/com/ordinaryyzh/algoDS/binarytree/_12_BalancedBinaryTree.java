package com.ordinaryyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * 给出一个二叉树，判断是否平衡树（平衡树的定义是任意左右两子树的深度差最大不超过1）
 * 百度百科：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 *
 * @author OrdinaryYZH
 * @date 2017/9/7 23:38
 */
public class _12_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果左边/右边不是平衡树，就可以判断整棵树都不是
        int leftsize = maxDepth(root.left);
        if (leftsize == -1) {
            return -1;
        }

        int rightsize = maxDepth(root.right);
        if (rightsize == -1) {
            return -1;
        }

        if (Math.abs(rightsize - leftsize) > 1) {
            return -1;
        }
        return 1 + Math.max(leftsize, rightsize);
    }
}
