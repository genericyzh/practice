package com.ordinaryyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * 给出一个二叉树，求出最大深度
 *
 * @author genericyzh
 * @date 2017/9/7 23:13
 */
public class _11_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
