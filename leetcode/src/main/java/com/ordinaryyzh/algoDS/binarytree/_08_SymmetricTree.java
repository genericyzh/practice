package com.ordinaryyzh.algoDS.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 * 判断一个二叉树是不是对称
 *
 * @author OrdinaryYZH
 * @date 2017/9/4 22:55
 */
public class _08_SymmetricTree {

    /**
     * 解法一：递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean con1 = left.val == right.val ? true : false;
        if (con1 == false) {
            return false;
        }
        boolean con2 = check(left.left, right.right);
        if (con2 == false) {
            return false;
        }
        boolean con3 = check(left.right, right.left);
        if (con3 == false) {
            return false;
        }
        return true;
    }

    /**
     * 非递归：BFS + 回文判断
     * 注意：
     * ArrayDeque不能添加null；
     * list.add(treeNode.left.val)会 nullpointexception
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            list.clear();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }

                if (treeNode.left == null) {
                    list.add(0);
                } else {
                    list.add(treeNode.left.val);
                }
                if (treeNode.right == null) {
                    list.add(0);
                } else {
                    list.add(treeNode.right.val);
                }
            }
            for (int i = 0; i <= (list.size() - 1) / 2; i++) {
                if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 非递归，使用两个队列模拟递归
     * 一层层的判断
     *
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode left = queue1.poll();
            TreeNode right = queue2.poll();
            // 1、两边都为null，不用处理
            // 2、一边为空，一边不为空，就不对称
            if ((left == null && right != null) ||
                    (left != null && right == null)) {
                return false;
            }
            // 3、两边都有值的情况
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                queue1.offer(left.left);
                queue1.offer(left.right);
                queue2.offer(right.right);
                queue2.offer(right.left);
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String str = "[1,2,2,3,4,4,3]";
        String str = "[1,2,2,null,3,null,3]";
        TreeNode node = TreeNode.mkTree(str);
        _08_SymmetricTree symmetricTree = new _08_SymmetricTree();
        boolean flag = symmetricTree.isSymmetric3(node);
        System.out.println(flag);
    }
}
