package com.genericyzh.algoDS.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 * 翻转二叉树
 *
 * @author genericyzh
 * @date 2017/8/30 23:31
 */
public class _03_InvertBinaryTree {

    /**
     * 深搜
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        // 这个return啥也没干，就返回参数root
        return root;
    }

    /**
     * 广搜
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swap(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
