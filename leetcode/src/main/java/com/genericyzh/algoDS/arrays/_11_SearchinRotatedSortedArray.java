package com.genericyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 *
 * @author genericyzh
 * @date 2017/7/12 23:43
 */
public class _11_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l != r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[l]) {
                if (target >= nums[l] && target <= nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (target >= nums[m] && target <= nums[r]) {
                    l = m;
                } else {
                    r = m - 1;
                }

            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        _11_SearchinRotatedSortedArray searchinRotatedSortedArray = new _11_SearchinRotatedSortedArray();
        System.out.println(searchinRotatedSortedArray.search(nums, 4));
        ;
    }
}
