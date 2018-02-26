package com.genericyzh.algoDS.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * 给出一个二叉树，返回中序遍历数组，不包括null
 *
 * @author genericyzh
 * @date 2017/9/5 22:37
 */
public class _09_BinaryTreeInorderTraversal {

    /**
     * 非递归，用栈辅助
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }


    void inOrder(TreeNode x, List<Integer> list) {
        if (x == null) return;
        inOrder(x.left, list);
        list.add(x.val);
        inOrder(x.right, list);
    }
}
