package com.genericyzh.algoDS.arrays;

import org.junit.Test;

import java.util.Arrays;

import static com.genericyzh.algoDS.arrays._01_RotateArray.rotate;
import static com.genericyzh.algoDS.arrays._01_RotateArray.rotate2;

/**
 * @author 大数据事业部-产品部-姚梓焕
 * @version 1.0
 * @date 2017/5/6 0:22
 */
public class _01_RotateArrayTest {

    @Test
    public void testRotate() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testRotate2() throws Exception {
        int[] nums = {-1};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testRotate3() throws Exception {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rotate2(nums, 6);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testReverse() throws Exception {

    }
}