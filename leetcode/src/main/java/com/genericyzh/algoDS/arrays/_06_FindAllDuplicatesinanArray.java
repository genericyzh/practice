package com.genericyzh.algoDS.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/#/solutions
 * 给出一个数组: 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once. // 有些出现2次，有些出现1次
 * Find all the elements that appear twice in this array. // 找出出现2次的数字
 *
 * @author genericyzh
 * @date 2017/6/26 23:39
 */
public class _06_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index]; // 把对应的数字变为相反数，用来判断是否出现第二次
        }
        return res;
    }

    public static void main(String[] args) {
        _06_FindAllDuplicatesinanArray findAllDuplicatesinanArray = new _06_FindAllDuplicatesinanArray();
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findAllDuplicatesinanArray.findDuplicates(a));
    }
}
