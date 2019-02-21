package com.ordinaryyzh.algoDS.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * 给出一个二叉树，返回每一行的最大节点val
 *
 * @author genericyzh
 * @date 2017/9/21 21:33
 */
public class _25_FindLargestElementinEachRow {

    /**
     * BFS + 简单判断即可
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 递归写法，先序遍历，添加dept参数判断是第几层
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }
        // 每层第一个的条件，0层->size=0,1层->size=1
        if (depth == res.size()) {
            res.add(root.val);
            // 每层其他节点的条件
        } else if (root.val > res.get(depth)) {
            res.set(depth, root.val);
        }
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree2("[1,3,2,5,3,null,9]");
        _25_FindLargestElementinEachRow findLargestElementinEachRow = new _25_FindLargestElementinEachRow();
        List<Integer> result = findLargestElementinEachRow.largestValues2(treeNode);
        System.out.println(result);
    }

}
