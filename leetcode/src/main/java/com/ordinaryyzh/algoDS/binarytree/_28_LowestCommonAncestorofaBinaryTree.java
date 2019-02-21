package com.ordinaryyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 题意：求二叉树 LCA
 *
 * @author genericyzh
 * @date 2018/3/1 10:46
 */
public class _28_LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.mkTree("[6,2,8,0,4,7,9,null,null,3,5,null,null,null,null]");
        _28_LowestCommonAncestorofaBinaryTree lowestCommonAncestorofaBinaryTree = new _28_LowestCommonAncestorofaBinaryTree();
//        TreeNode node1 = lowestCommonAncestorBST.lowestCommonAncestor(node, new TreeNode(10), new TreeNode(12));
        TreeNode node1 = lowestCommonAncestorofaBinaryTree.lowestCommonAncestor(node, new TreeNode(1), new TreeNode(10));
        System.out.println(node1);
    }

}
