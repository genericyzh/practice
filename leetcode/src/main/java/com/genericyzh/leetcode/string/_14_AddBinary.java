package com.genericyzh.leetcode.string;

/**
 * https://leetcode.com/problems/add-binary/description/
 * 题意：给出两个二进制字符串，返回他们的和（也是字符串格式）
 *
 * @author genericyzh
 * @date 2018/3/29 23:39
 */
public class _14_AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
