package com.ordinaryyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 给出一个升序数组，将其转换成一个尽量平衡的二叉树
 * 注意边界，当nums长度为2时，l = m = 0，下次的l = 0，r = -1(m-1)，所以终止条件为:l > r -> return null
 * 当nums.length = 3时，第二次递归，左节点：l = r = 0，右节点：l = r = 2,所以l > r -> return null没问题
 *
 * @author OrdinaryYZH
 * @date 2017/9/12 22:55
 */
public class _16_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int l, int r) {
        // 注意这里
        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode treeNode = new TreeNode(nums[m]);
        treeNode.left = buildBST(nums, l, m - 1);
        treeNode.right = buildBST(nums, m + 1, r);
        return treeNode;
    }
}
