package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * 给出一个二叉树，转换成另一种形式的树，变成一个先序遍历的"右叉树"
 *
 * @author genericyzh
 * @date 2017/9/3 22:07
 */
public class _07_FlattenBinaryTreetoLinkedList {

    /**
     * 解法1：
     * 思路是先利用DFS的思路找到最左子节点，
     * 然后回到其父节点，把其父节点和右子节点断开，将原左子结点连上父节点的右子节点上，
     * 然后再把原右子节点连到新右子节点的右子节点上，然后再回到上一父节点做相同操作
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

    private TreeNode prev = null;

    /**
     * 解法2，可以发现要做到左边最后遍历的节点 = 右边的第一个节点
     * 下面的做法可以达到这个效果
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * 非递归
     * 参考：http://www.cnblogs.com/grandyang/p/4293853.html
     *
     * @param root
     */
    public void flatten3(TreeNode root) {
        if (root == null)
            return;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}