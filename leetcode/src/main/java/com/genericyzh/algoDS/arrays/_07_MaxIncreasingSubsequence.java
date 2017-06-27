package com.genericyzh.algoDS.arrays;

/**
 * @author genericyzh
 * @date 2017/6/27 23:39
 */
public class _07_MaxIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) // 以大于为判断标准，符合才往右移动
                    i = m + 1;
                else
                    j = m; // m = (i + j) / 2 这种写法j跟m是不相等的，所以不会死循环;如果是==的话，不会增长size
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
/*
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (num < tails[m]) {
                    j = m - 1;
                } else {
                    i = m+1;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
*/

    public static void main(String[] args) {
        _07_MaxIncreasingSubsequence maxIncreasingSubsequence = new _07_MaxIncreasingSubsequence();
        int[] a = {3, 3, 3, 3, 3};
        System.out.println(maxIncreasingSubsequence.lengthOfLIS(a));
    }
}
