package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/same-tree/description/
 * 给出两颗二叉树，判断是否一样
 *
 * @author genericyzh
 * @date 2017/9/6 22:28
 */
public class _10_SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 自己写的
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null)
                || (p != null && q == null)) {
            return false;
        }
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            boolean con1 = isSameTree(p.left, q.left);
            boolean con2 = isSameTree(p.right, q.right);
            return con1 & con2;
        }
        return true;
    }

    /**
     * 别人写的。。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;
        if (p.val != q.val)
            return false;
        return isSameTree2(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
