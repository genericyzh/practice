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

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode2(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode2(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) {
                rightSmallest = rightSmallest.left;
            }
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

    public TreeNode deleteNode3(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode3(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode3(root.right, key);
        } else {
            // 注：不返回当前root，就相当于当前root删除
            // 左右其中为空，返回另外一个
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 左右都不空，返回右子树最小节点
            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) {
                rightSmallest = rightSmallest.left;
            }
            // 以下顺序不能调转
            // 因为如果先rightSmallest.left = root.left; 那么递归root.right时，最小节点的left就不为空，会出现期望外的结果
            rightSmallest.right = deleteNode3(root.right, rightSmallest.val);
            rightSmallest.left = root.left;
            return rightSmallest;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.mkTree("[5,3,6,2,4,null,7]");
        _19_DeleteNodeinaBST deleteNodeinaBST = new _19_DeleteNodeinaBST();
        TreeNode node1 = deleteNodeinaBST.deleteNode3(node, 3);
        System.out.println(node1);
    }
}
