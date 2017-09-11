package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * 给出一个二叉树，判断是否是搜索树
 * 要注意不能只比较父的两个子节点，子节点是否还符合跟上层都有关系
 *
 * @author genericyzh
 * @date 2017/9/11 22:59
 */
public class _15_ValidateBinarySearchTree {

    /**
     * 不通过父节点比较子，只比较子的跟上一层的
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        if (helper(root.left, lower, root.val) == false) {
            return false;
        }
        if (helper(root.right, root.val, upper) == false) {
            return false;
        }
        return true;
    }

    /**
     * 父子都比较，会更快点
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min && isValid(root.left, root.val, min) && isValid(root.right, max, root.val)) {
            return true;
        } else {
            return false;
        }
    }
}
