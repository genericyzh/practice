package com.genericyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/#/description
 * 求最大连续子序列最大和
 * 问题分解： dp[i] means：当前值跟dp[i-1]连起来的最大值，当前值一定要加上，因为是要求连续的
 * dp[i] = a[i] + dp[i-1] 两个数相加，应该会有4种组合情况 （理解错误了，因为要连续的，所以不能这么想）
 * <p>
 * 初始化 dp[0] = nums[0]，后面的就可以推算出了
 *
 * @author grenericyzh
 * @date 2017/6/24 23:57
 */
public class _04_Maximum_Subarray {
    /**
     * 错误示范
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] >= 0 && dp[i - 1] >= 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else if (nums[i] >= 0 && dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else if (nums[i] < 0 && dp[i - 1] >= 0) {
                dp[i] = dp[i - 1];
            } else if (nums[i] < 0 && dp[i - 1] < 0) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return dp[n - 1];

    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < length; i++) {
            int temp = nums[i] + (dp > 0 ? dp : 0); // 因为要连续，所以nums[i]时一定要加的
            dp = temp;
            max = Math.max(temp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        _04_Maximum_Subarray maximum_subarray = new _04_Maximum_Subarray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] a = {-1, -2};
        int i = maximum_subarray.maxSubArray(a);
        System.out.println(i);
    }
}
