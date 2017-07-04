package com.genericyzh.algoDS.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/#/description
 * 给出一个不重复的数组，将其打乱
 * <p>
 * 参考：
 * 对于单个元素来讲，以上算法显然正确，因为交换后仍然只有一个元素。
 * 接下来我们不妨假设其遍历到数组索引为i-1时满足随机排列特性，
 * 那么当遍历到数组索引为i时，随机数k为i的概率为1/i,为0~i-1的概率为(i-1)/i.
 * 接下来与索引为i的值交换，可以得知card[i]出现在索引i的位置的概率为1/i, 在其他索引位置的概率也为1/i;
 * 而对于card[i]之前的元素，以索引j处的元素card[j]为例进行分析可知，其在位置j的概率为1/(i-1) * (i-1)/i = 1/i, 具体含义为遍历到索引i-1时card[j]位于索引j的概率(1/(i-1))乘以遍历到索引i时随机数未选择与索引j的数进行交换的概率((i-1)/i).
 * 需要注意的是前面的j <= i-1,
 * 那么card[j]位于索引i的概率又是多少呢？要位于索引i，则随机数k须为i, 这种概率为1/i.
 *
 * @author genericyzh
 * @date 2017/7/3 23:50
 */
public class _09_ShuffleanArray {
    int[] nums;
    int[] cards;

    public _09_ShuffleanArray(int[] nums) {
        this.nums = nums;
        cards = new int[nums.length];
        System.arraycopy(nums, 0, cards, 0, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns cards random shuffling of the array.
     */
    public int[] shuffle() {
        if (cards == null || cards.length == 0)
            return new int[0];

        Random random = new Random();
        for (int i = 1; i < cards.length; i++) {
            int j = random.nextInt(i + 1);
            int temp = cards[j];
            cards[j] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        _09_ShuffleanArray shuffleanArray = new _09_ShuffleanArray(nums);
        int[] shuffle = shuffleanArray.shuffle();
        System.out.println(Arrays.toString(shuffle));
    }
}
