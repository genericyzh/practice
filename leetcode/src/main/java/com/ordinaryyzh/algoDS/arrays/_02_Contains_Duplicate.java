package com.ordinaryyzh.algoDS.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate
 * 给出一个数组，判断是否有重复元素
 *
 * @author genericyzh
 * @date 2017/6/21 23:32
 */
public class _02_Contains_Duplicate {
    /**
     * 我的..
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        } else if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] == ints[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int ind = 1; ind < nums.length; ind++) {
            if (nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用Set
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate3(int[] nums) {
        final Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    /**
     * In iteration of array We keep track of elements and in each iteration we need to check if this elements is
     * met already.
     */
    public static boolean containsDuplicate4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        _02_Contains_Duplicate contains_duplicate = new _02_Contains_Duplicate();
        int[] nums = {1, 2, 6, 4, 5};
        System.out.println(contains_duplicate.containsDuplicate2(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
