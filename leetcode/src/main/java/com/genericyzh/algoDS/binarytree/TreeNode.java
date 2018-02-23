package com.genericyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TreeNode类包含构造树的方法
 *
 * @author genericyzh
 * @date 2017/9/6 23:37
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
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

    public static TreeNode mkTree(String str) {
        int[] arr = StrToIntArray(str);
        TreeNode root = new TreeNode(arr[0]);
        if (arr.length <= 1) {
            return root;
        }
        TreeNode temp;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int j = 1;
        while (!queue.isEmpty()) {
            temp = queue.pollFirst();
            if (arr[j] != Integer.MAX_VALUE) {
                TreeNode leftNode = new TreeNode(arr[j]);
                temp.left = leftNode;
                queue.offerLast(leftNode);
            }
            j++;
            if (j >= arr.length) {
                return root;
            }
            if (arr[j] != Integer.MAX_VALUE) {
                TreeNode rightNode = new TreeNode(arr[j]);
                temp.right = rightNode;
                queue.offerLast(rightNode);
            }
            j++;
            if (j >= arr.length) {
                return root;
            }
        }

        return root;
    }

    /**
     * 不是一个正确的构造方法，只支持都有节点的树，例外：[1,1,2,1,null,2,null,null,null,null,2]，会构造出错误的树
     * [1,1,2,1,null,2,null,null,null,null,2,null,null]才可以，用_01_BinaryTreeLevelOrderTraversal测试貌似也是错误的(2018/02/23)
     * String str = "[3,9,20,null,null,15,7]";
     */
    public static TreeNode mkTree2(String str) {

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

