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
     * 父子都比较，会更快点（看上去感觉跟上面的解法一毛一样-2018/02/27）
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

    /**
     * 错误，以下只判断了root的左右节点，不能判断root的所有左节点/右节点都满足
     * e.g.[10,5,15,null,null,6,20]
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST3(root.left) & isValidBST3(root.left);
    }

    public boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean check(TreeNode root, long low, long high) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && !(low < root.left.val && root.left.val < root.val)) {
            return false;
        }
        if (root.right != null && !(root.val < root.right.val && root.right.val < high)) {
            return false;
        }
        boolean check = true;
        if (root.left != null) {
            check = check(root.left, low, root.val);
        }
        if (check == false) {
            return false;
        }
        boolean check2 = true;
        if (root.right != null) {
            check2 = check(root.right, root.val, high);
        }
        if (check2 == false) {
            return false;
        }
        return true;
    }

}
