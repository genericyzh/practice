package com.ordinaryyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 * 一个向右移动过的升序数组，给出target，找出在数组里面的下标，如果没找到返回-1
 * 这题可以说是标准的二分法写法，值得学习
 *
 * @author genericyzh
 * @date 2017/7/12 23:43
 */
public class _11_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) { // 要用<=，例子：nums{1},如果用!=，会直接返回-1
            int m = l + (r - l) / 2;
            // 把m的过滤掉先，下面就不用判断了，直接m+1/m-1
            if (target == nums[m]) {
                return m;
            }
            if (nums[m] >= nums[l]) {
                // m不能用=，上面已经判断过了
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                // m不能用=，上面已经判断过了
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            }
        }
        return -1;
    }

    int search2(int A[], int target) {
        int n = A.length;
        int lo = 0, hi = n - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] > A[hi]) lo = mid + 1;
            else hi = mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0;
        hi = n - 1;
        // The usual binary search and accounting for rotation.
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (A[realmid] == target) return realmid;
            if (A[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3};
//        int[] nums = {1};
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {3, 4, 5, 6, 0, 1, 2};
        int[] nums = {1};
        _11_SearchinRotatedSortedArray searchinRotatedSortedArray = new _11_SearchinRotatedSortedArray();
//        System.out.println(searchinRotatedSortedArray.search(nums, 0));
        System.out.println(searchinRotatedSortedArray.search(nums, 1));
    }
}
