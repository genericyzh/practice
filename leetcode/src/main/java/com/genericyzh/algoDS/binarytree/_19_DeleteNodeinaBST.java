package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * 给出一个二叉搜搜树，删除一个节点
 *
 * @author genericyzh
 * @date 2017/9/16 23:55
 */
public class _19_DeleteNodeinaBST {
    /**
     * @param root
     * @param key
     * @return 新的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left != null && root.right != null) {
                root.val = findMin(root.right).val; // 找出右节点最小的填到要删除的节点处
                root.right = deleteNode(root.right, root.val); // 删除右子树最小的节点
            } else {
                return root.left != null ? root.left : root.right;
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
