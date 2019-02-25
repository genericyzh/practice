package com.ordinaryyzh.offer.chapter4;

import com.ordinaryyzh.offer.TreeNode;

/**
 * @author OrdinaryYZH
 * @date 2018/2/23 23:46
 */
public class _19_BinaryTreeMirror {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

}
