package com.genericyzh.algoDS.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 给出一个二叉树，依次输出每一层的节点(DFS)
 *
 * @author genericyzh
 * @date 2017/8/28 23:37
 */
public class _01_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            // 这里应该返回[]，而不是null
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode node = TreeNode.mkTree("[3,9,20,null,null,15,7]");
        TreeNode node = TreeNode.mkTree("[1,1,2,1,null,2,null,null,null,null,2]");
        _01_BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new _01_BinaryTreeLevelOrderTraversal();
        List<List<Integer>> list = binaryTreeLevelOrderTraversal.levelOrder(node);
        list.forEach(System.out::println);
    }
}
