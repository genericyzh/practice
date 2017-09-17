package com.genericyzh.algoDS.binarytree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * 求搜索树的两个节点的最小公共祖先（ lowest common ancestor (LCA)）
 *
 * @author genericyzh
 * @date 2017/9/17 23:30
 */
public class _20_LowestCommonAncestorBST {
    /**
     * 在同一边时，继续遍历
     * 不在同一边时：
     * 1、公共祖先不是其中一个节点
     * 2、公共祖先是其中一个节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 都在左边
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 都在右边
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
