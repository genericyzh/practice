package com.ordinaryyzh.algoDS.binarytree;

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

    /**
     * 非递归
     * 注意：这里用乘法判断是因为，p跟q的大小不确定
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }

    /**
     * 递归，一行搞定
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
                lowestCommonAncestor3(p.val < root.val ? root.left : root.right, p, q);
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.mkTree("[6,2,8,0,4,7,9,null,null,3,5,null,null,null,null]");
        _20_LowestCommonAncestorBST lowestCommonAncestorBST = new _20_LowestCommonAncestorBST();
//        TreeNode node1 = lowestCommonAncestorBST.lowestCommonAncestor(node, new TreeNode(10), new TreeNode(12));
        TreeNode node1 = lowestCommonAncestorBST.lowestCommonAncestor(node, new TreeNode(1), new TreeNode(10)); // 错误例子
        System.out.println(node1);
    }
}
