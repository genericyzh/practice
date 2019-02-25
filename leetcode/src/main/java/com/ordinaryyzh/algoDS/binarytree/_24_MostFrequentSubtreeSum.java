package com.ordinaryyzh.algoDS.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 * 给出一个二叉树，求子树的和中，出现最多的和次数最多的是哪些
 * 跟_23_FindModeinBST差不多的做法，有n各节点 -> 有n个子树，后序遍历 + hashmap
 *
 * @author OrdinaryYZH
 * @date 2017/9/20 23:26
 */
public class _24_MostFrequentSubtreeSum {

    int max = 1;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        getSum(root, map);

        int[] result = map.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue().equals(max))
                .map(integerIntegerEntry -> integerIntegerEntry.getKey())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return result;
    }

    private int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left, map);
        int rightSum = getSum(root.right, map);
        int sum = leftSum + rightSum + root.val;
        int val = map.getOrDefault(sum, 0) + 1;
        map.put(sum, val);
        max = Math.max(max, val);
        return sum;
    }

    private int getSum2(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum2(root.left, map);
        int rightSum = getSum2(root.right, map);
        int sum = leftSum + rightSum + root.val;
        if (map.containsKey(sum)) {
            int val = map.get(sum) + 1;
            map.put(sum, val);
            max = Math.max(max, val);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree2("[5,2,-3]");
        _24_MostFrequentSubtreeSum mostFrequentSubtreeSum = new _24_MostFrequentSubtreeSum();
        int[] frequentTreeSum = mostFrequentSubtreeSum.findFrequentTreeSum(treeNode);
        System.out.println(Arrays.toString(frequentTreeSum));
    }
}
