package com.genericyzh.algoDS.arrays;

/**
 * leetcode https://leetcode.com/problems/rotate-array/#/description
 * https://leetcode.com/articles/rotate-array/
 * 将一个数组向右移动k位
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * @author yao
 * @date 2017/5/1 23:40
 */
public class _01_RotateArray {
    /**
     * 方法一：先整体翻转，再将两部分各自翻转即可；
     * 注意；翻转再翻转之后，那么原来的下标位置也是顺序的，e.g.  1,2,3,4,5,6,7 -> 7,6,5,4,3,2,1;从第三位翻：5,6,7,1,2,3,4,从第五位翻：3,4,5,4,7,1,2
     * 【1,2,3这些数字的意思是下标位置】
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException("数组不能为空");
        }
        int length = nums.length;
        k %= length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 方法2：自己计算每次要移动的下标，总共移动了nums.length次之后，就成功了
     * 这是一种纯操作的方式
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException("数组不能为空");
        }
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current); // 有可能形成环,有环的情况下要跳出，不然会死循环
        }
    }

}
