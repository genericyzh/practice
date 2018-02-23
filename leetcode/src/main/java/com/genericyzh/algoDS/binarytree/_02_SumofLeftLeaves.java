package com.genericyzh.algoDS.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * 给出一个二叉树，输出"左叶子节点"之和
 * ** 3
 * * / \
 * *9  20
 * ** /  \
 * * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * @author genericyzh
 * @date 2017/8/29 22:59
 */
public class _02_SumofLeftLeaves {

    /**
     * 解法一，深搜(递归)
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            // 判断左叶子节点
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    /**
     * 错误解法，左叶子节点判断错误
     * root不知道是左节点还是右节点
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left != null) {
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    /**
     * 解法二：BFS + 队列辅助
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    queue.add(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }

    /**
     * 解法3：用栈；
     * 用栈的话，遍历方式跟递归差不多，但这里会先遍历右节点，再遍历左节点
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }
}
