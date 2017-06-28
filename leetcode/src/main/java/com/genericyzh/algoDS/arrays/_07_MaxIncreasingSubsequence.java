package com.genericyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/#/description
 * <p>
 * tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
 * For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
 * <p>
 * len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
 * len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
 * len = 3   :      [4, 5, 6]            => tails[2] = 6
 * We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
 * <p>
 * Each time we only do one of the two:
 * <p>
 * (1) if x is larger than all tails, append it, increase the size by 1
 * (2) if tails[i-1] < x <= tails[i], update tails[i]
 *
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
                    j = m; // m = (i + j) / 2 这种写法j跟m是不相等的，在i==j之前，j都会大于m，所以不会死循环;如果是==的话，不会增长size
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        // 有可能：[1,2,11,12,13,3,4,5,6,7]；没办法一步得到最长，只好都遍历计算；当然上面第一种算法挺屌的
        for (int i = 0; i < nums.length; i++) {
            int maxl = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxl = Math.max(maxl, dp[j] + 1);
                }
            }
            dp[i] = maxl;
            result = Math.max(maxl, result);
        }
        return result;
    }

    //region 注释代码
   /* public int lengthOfLIS(int[] nums) {
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
    }*/
    //endregion


    public static void main(String[] args) {
        _07_MaxIncreasingSubsequence maxIncreasingSubsequence = new _07_MaxIncreasingSubsequence();
        int[] a = {};
//        int[] a = {-3, -2, -1, 1, 2};
//        int[] a = {3, 3, 3, 3, 3};
        System.out.println(maxIncreasingSubsequence.lengthOfLIS2(a));
    }
}
