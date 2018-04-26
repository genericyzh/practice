package com.genericyzh.algoDS.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 * 给出一个存在重复数字的搜索树：左节点小于等于中j节点，右节点大于等于中节点
 * 求：出现次数最多的数字，可能有多个，返回数组
 * （最好能够不使用多余的存储空间）
 *
 * @author genericyzh
 * @date 2017/9/19 22:14
 */
public class _23_FindModeInBST {
    int maxCount = 0;
    int curCount = 0;
    int modeCount;
    int[] modes;
    int curVal;

    public int[] findMode(TreeNode root) {
        inorder(root); // 第一次遍历只是确定最多有多少个
        modes = new int[modeCount];
        modeCount = 0;
        curCount = 0;
        inorder(root); // 第二次遍历才构造数组
        return modes;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

    /**
     * 处理方法
     *
     * @param value
     */
    private void handleValue(int value) {
        if (value != curVal) {
            curVal = value;
            curCount = 0;
        }
        curCount++;
        if (curCount > maxCount) {
            maxCount = curCount;
            modeCount = 1;
        } else if (curCount == maxCount) {
            // 第一次遍历时，modes为null
            if (modes != null) {
                modes[modeCount] = value;
            }
            modeCount++;
        }
    }


    int max = 1;

    /**
     * 解法二，借助map
     *
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        find(root, map);
        int[] ints = map.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() == max)
                .map(integerIntegerEntry1 -> integerIntegerEntry1.getKey())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        /*List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == max) {
                list.add(integer);
            }
        }
        int[] a = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            a[i++] = integer;
        }*/

        return ints;
    }

    private void find(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        int val = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, val);
        max = Math.max(max, val);
        find(root.left, map);
        find(root.right, map);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.mkTree2("[1,1,2,1,null,2,null,null,null,2,null]");
        TreeNode treeNode = TreeNode.mkTree("[1,1,1,0,null,null,2,null,null,2,2]");
        _23_FindModeInBST findModeinBST = new _23_FindModeInBST();
        int[] mode = findModeinBST.findMode2(treeNode);
        System.out.println(Arrays.toString(mode));
    }
}
