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

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return Integer.toString(val);
        }

        //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
        private static int[] StrToIntArray(String str) {
            str = str.substring(1, str.length() - 1);
            String[] strs = str.split(",");
            int[] arr = new int[strs.length];

            for (int i = 0; i < arr.length; i++) {
                if (strs[i].equals("null")) {
                    arr[i] = Integer.MAX_VALUE;
                } else {
                    arr[i] = Integer.parseInt(strs[i]);
                }
            }

            return arr;
        }

        //    String str = "[3,9,20,null,null,15,7]";
        public static TreeNode mkTree(String str) {

            int[] arr = StrToIntArray(str);
            TreeNode[] nodes = new TreeNode[arr.length + 1];
            for (int i = 1; i < nodes.length; i++) {
                if (arr[i - 1] != Integer.MAX_VALUE) {
                    nodes[i] = new TreeNode(arr[i - 1]);
                } else {
                    nodes[i] = null;
                }
            }

            TreeNode node = null;
            for (int i = 1; i < nodes.length / 2; i++) {
                node = nodes[i];
                if (node == null) continue;
                node.left = nodes[2 * i];
                node.right = nodes[2 * i + 1];
            }
            return nodes[1];
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

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


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
        inOrderIterative(root, list);
        return list;
    }

    private void inOrderIterative(TreeNode x, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();

        while (x != null || !stack.isEmpty()) {
            while (x != null) {
                stack.add(x);
                x = x.left;
            }
            x = stack.pop();
            list.add(x.val);
            x = x.right;
        }
    }

    void inOrder(TreeNode x, List<Integer> list) {
        if (x == null) return;
        inOrder(x.left, list);
        list.add(x.val);
        inOrder(x.right, list);
    }
}
