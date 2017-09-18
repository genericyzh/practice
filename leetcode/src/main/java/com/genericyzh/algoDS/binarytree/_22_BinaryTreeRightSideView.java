package com.genericyzh.algoDS.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * 给出一个搜索树，输出你在右边看到的节点，从上到下输出
 *
 * @author genericyzh
 * @date 2017/9/18 22:17
 */
public class _22_BinaryTreeRightSideView {

    /**
     * BFS，输出每一层最右边的节点
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer val = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (i == size - 1) {
                    val = node.val;
                }
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
            result.add(val);
        }
        return result;
    }

    /**
     * 解法2：先遍历右节点
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> lst = new LinkedList<>();
        helper(root, 0, lst);
        return lst;
    }

    /**
     * 这种递归写法，靠右的都会先被遍历到
     *
     * @param root    当前节点
     * @param current 第几层
     * @param lst     结果集
     */
    private void helper(TreeNode root, int current, List<Integer> lst) {
        if (root == null) {
            return;
        }
        // 判断能否添加节点，current相当于第几层
        if (lst.size() <= current) {
            lst.add(root.val);
        }
        helper(root.right, current + 1, lst);
        helper(root.left, current + 1, lst);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[1,2,3,null,5,null,4]");
        _22_BinaryTreeRightSideView binaryTreeRightSideView = new _22_BinaryTreeRightSideView();
        List<Integer> result = binaryTreeRightSideView.rightSideView(treeNode);
        System.out.println(result);
    }
}
