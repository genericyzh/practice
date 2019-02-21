package com.ordinaryyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/find-peak-element/#/description
 * 题目：给定一个左右相邻不相等的数组，找出一个局部最大值。PS：num[-1]=num[n]=-∞
 * 可以理解为多个山峰的一个数组,找出一个山峰；可以跟一个向左/右移动的排序数组作为对比题目
 *
 * @author genericyzh
 * @date 2017/6/22 23:06
 */
public class _03_Find_Peak_Element {
    /**
     * 使用二分法:
     * 跟右边比
     * 1、mid > mid+1：肯定在左边 -> find(nums,0,mid)
     * 2、mid < mid+1：肯定在右边 -> find(nums,mid,n)
     * <p>
     * 跟左边比较，同理：
     * 1、mid > mid-1：肯定在有边 -> find(nums,mid,n)
     * 2、mid < mid-1：肯定在左边 -> find(nums,0,mid)
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        // 每次筛选都会去掉部分下标
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, left, mid); // 右边的没了
        }
        return binarySearch(nums, mid + 1, right); // 左边的没了
        // 最后一次应该剩下2个，比如下标3跟4，mid=3；一比较就能得到3，3或者4,4，下轮递归就结束了
    }

    /**
     * 错误示范；
     * mid = (left + right) / 2，就不要用mid跟mid - 1比较，当只剩下两个元素的时候，mid - 1就不准确了
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int binarySearch2(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid - 1] > nums[mid]) {
            return binarySearch(nums, left, mid - 1);
        }
        return binarySearch2(nums, mid, right);
    }

    public static void main(String[] args) {
        _03_Find_Peak_Element find_peak_element = new _03_Find_Peak_Element();
        int peakElement = find_peak_element.findPeakElement(new int[]{1, 2, 3, 1});
        System.out.println(peakElement);
    }

}
