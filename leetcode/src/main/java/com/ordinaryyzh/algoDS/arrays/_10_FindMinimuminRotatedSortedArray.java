package com.ordinaryyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 * 假设一个排好序的数组在某处执行了一次“旋转”，找出最小的元素（数组元素不重复）
 *
 * @author OrdinaryYZH
 * @date 2017/7/10 22:20
 */
public class _10_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        // 判断是升序还是降序，升序只有一次跌的机会,同理，降序也一样
        int isAscending = (nums[0] < nums[1] ? 1 : 0) + (nums[1] < nums[2] ? 1 : 0) + (nums[2] < nums[0] ? 1 : 0);
        int l = 0;
        int r = nums.length - 1;
        while (l != r) {
            int m = l + (r - l) / 2;  // It can avoid overflow. 防止l > r
            if (isAscending >= 1) {
                if (nums[l] < nums[r]) {
                    return nums[l];
                }
                if (nums[m] > nums[l]) {
                    l = m + 1;
                } else {
                    // 因为数字不重复，所以l++
                    l++;
                    r = m;
                }
            } else {
                if (nums[l] > nums[r]) {
                    return nums[r];
                }
                if (nums[m] < nums[l]) {
                    l = m;
                    r--;
                } else {
                    r = m - 1;
                }
            }
        }
        return nums[l];
    }

    /**
     * 解法2，参考剑指offer面试题8：旋转数组的最小数字
     * indexL总是在左边，indexR总是在右边；
     * 注意特殊情况：没选转过的时候，int result = 0跟while(nums[indexL] >= nums[indexR])可以解决
     * minInOrder处理了存在重复的数字的情况
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int indexL = 0;
        int indexR = nums.length - 1;
        int result = 0; // 坑1：处理已经排好序的了
        while (nums[indexL] >= nums[indexR]) {
            if (indexR - indexL == 1) {
                result = indexR;
                break;
            }
            int indexMid = (indexL + indexR) / 2;
            // 坑2：处理三个值一样大小的情况：
            // indexL、indexMid、indexR指向的三个数字相等， 则只能顺序查找
            if (nums[indexL] == nums[indexR] && nums[indexL] == nums[indexMid]) {
                return minInOrder(nums, indexL, indexR);
            }

            if (nums[indexMid] >= nums[indexL]) {
                indexL = indexMid;
            } else {
                indexR = indexMid;
            }
        }
        return nums[result];
    }

    private int minInOrder(int[] nums, int indexL, int indexR) {
        int result = nums[indexL];
        for (int i = indexL + 1; i <= indexR; i++) {
            if (result > nums[i]) {
                result = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _10_FindMinimuminRotatedSortedArray().findMin2(
                //new int[]{6,7,1,2,3,4,5}
                new int[]{4, 5, 6, 7, 0, 1, 2}
                //new int[]{3,4,5,6,7,1,2}
        ));
    }

}
