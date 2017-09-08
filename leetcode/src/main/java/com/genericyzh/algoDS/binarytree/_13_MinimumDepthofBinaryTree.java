package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * 给出一个二叉树，返回最浅的深度(跟叶子节点最接近的距离)
 *
 * @author genericyzh
 * @date 2017/9/8 23:27
 */
public class _13_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 && right == 0) {
            return 1;
        }
        if (left == 0 && right != 0) {
            return right + 1;
        }
        if (left != 0 & right == 0) {
            return left + 1;
        }
        return 1 + Math.min(left, right);
    }

    /**
     * 写法2，比我的简洁多了
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if (left == 0 || right == 0)
            return 1 + left + right;
        return 1 + Math.min(left, right);
    }

    /**
     * 写法3
     *
     * @param root
     * @return
     */
    public int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 先判断子节点是否为空
        if (root.left == null || root.right == null) {
            return Math.max(minDepth3(root.left), minDepth3(root.right)) + 1;
        }

        int left = minDepth3(root.left);
        int right = minDepth3(root.right);

        return (left > right ? right : left) + 1;

    }

    public static void main(String[] args) {
        _13_MinimumDepthofBinaryTree minimumDepthofBinaryTree = new _13_MinimumDepthofBinaryTree();
        TreeNode treeNode = TreeNode.mkTree("[3,9,20,null,null,15,7]");

        System.out.println(minimumDepthofBinaryTree.minDepth(treeNode));
    }
}
