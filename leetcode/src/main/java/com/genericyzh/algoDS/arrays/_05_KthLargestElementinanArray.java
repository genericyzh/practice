package com.genericyzh.algoDS.arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
 * 在数组中找到第k大的元素
 * 几种解法：
 * 1、O(N lg N) running time + O(1) memory 直接快排，选出nums[k]
 * 2、O(N lg K) running time + O(K) memory 使用优先队列
 * 3、快速选择算法
 * 参考题解：https://leetcode.com/problems/kth-largest-element-in-an-array/#/solutions 第三种方法看不懂...
 *
 * @author genericyzh
 * @date 2017/6/25 23:09
 */
public class _05_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    int partition(int[] a, int lo, int hi, int k) {
        int p = (lo + hi) / 2; // 选择pivot
        int curIndex = lo;

        // 把小于pivot的元素从左堆到右
        swap(a, p, hi); // 先弄到最后
        for (int i = lo; i < hi; i++) {
            if (a[i] < a[hi]) {
                swap(a, i, curIndex++);
            }
        }
        swap(a, curIndex, hi); // 记得还原

        if (curIndex == k) {
            return a[k];
        } else if (curIndex < k) { // k在右边，继续筛选
            return partition(a, curIndex + 1, hi, k);
        } else { // k在左边，继续筛选
            return partition(a, lo, curIndex - 1, k);
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        _05_KthLargestElementinanArray kthLargestElementinanArray = new _05_KthLargestElementinanArray();
        int[] a = {3, 2, 1, 5, 6, 4};
        int kthLargest = kthLargestElementinanArray.findKthLargest(a, 2);
        System.out.println(kthLargest);
    }
}
