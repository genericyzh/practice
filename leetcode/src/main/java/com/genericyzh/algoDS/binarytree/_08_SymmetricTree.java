package com.genericyzh.algoDS.binarytree;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 * 判断一个二叉树是不是对称
 *
 * @author genericyzh
 * @date 2017/9/4 22:55
 */
public class _08_SymmetricTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return Integer.toString(val);
        }

        //    int []arr = {3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7};
        private static int[] StrToIntArray(String str) {
            str = str.substring(1, str.length() - 1);
            String[] strs = str.split(",");
            int[] arr = new int[strs.length];

            for (int i = 0; i < arr.length; i++) {
                if (strs[i].equals("null")) {
                    arr[i] = Integer.MAX_VALUE;
                } else {
                    arr[i] = Integer.parseInt(strs[i]);
                }
            }

            return arr;
        }

        //    String str = "[3,9,20,null,null,15,7]";
        public static TreeNode mkTree(String str) {

            int[] arr = StrToIntArray(str);
            TreeNode[] nodes = new TreeNode[arr.length + 1];
            for (int i = 1; i < nodes.length; i++) {
                if (arr[i - 1] != Integer.MAX_VALUE) {
                    nodes[i] = new TreeNode(arr[i - 1]);
                } else {
                    nodes[i] = null;
                }
            }

            TreeNode node = null;
            for (int i = 1; i < nodes.length / 2; i++) {
                node = nodes[i];
                if (node == null) continue;
                node.left = nodes[2 * i];
                node.right = nodes[2 * i + 1];
            }
            return nodes[1];
        }
    }

    /**
     * 解法一：递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean con1 = left.val == right.val ? true : false;
        boolean con2 = check(left.left, right.right);
        boolean con3 = check(left.right, right.left);
        return con1 & con2 & con3;
    }

    /**
     * 非递归，错误
     * 注意：ArrayDeque不能添加null；
     * list.add(treeNode.left.val)会 nullpointexception
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            list.clear();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
                list.add(treeNode.left.val);
                list.add(treeNode.right.val);
            }
//            Integer[] integers = Arrays.<Integer, Integer>copyOf(list.toArray(new Integer[list.size()]), list.size(), Integer[].class);
            list2 = new ArrayList<>(Collections.nCopies(list.size(), 0));
            Collections.copy(list2, list);
            Collections.reverse(list2);
            boolean flag = Objects.deepEquals(list, list2);
            if (flag == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root.left);
        queue2.offer(root.right);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode left = queue1.poll();
            TreeNode right = queue2.poll();
            // 1、两边都为null，不用处理
            // 2、一边为空，一边不为空，就不对称
            if ((left == null && right != null) ||
                    (left != null && right == null)) {
                return false;
            }
            // 3、两边都有值的情况
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                queue1.offer(left.left);
                queue1.offer(left.right);
                queue2.offer(right.right);
                queue2.offer(right.left);
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String str = "[1,2,2,3,4,4,3]";
        String str = "[1,2,2,null,3,null,3]";
        TreeNode node = TreeNode.mkTree(str);
        _08_SymmetricTree symmetricTree = new _08_SymmetricTree();
        boolean flag = symmetricTree.isSymmetric3(node);
        System.out.println(flag);
    }
}
