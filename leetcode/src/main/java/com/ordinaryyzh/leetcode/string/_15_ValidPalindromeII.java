package com.ordinaryyzh.leetcode.string;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 * 题意：判断字符串是否回文串，最多能够删除一个字符串
 *
 * @author OrdinaryYZH
 * @date 2018/3/30 11:07
 */
public class _15_ValidPalindromeII {

    /**
     * 方法一：使用char[]，这个方法比较快
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (sc[i] != sc[j]) {
                return helper(sc, i + 1, j) || helper(sc, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    boolean helper(char[] sc, int i, int j) {
        while (i < j) {
            if (sc[i] != sc[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 方法2：使用String API
     *
     * @param s
     * @return
     */
    public boolean validPalindrome2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPaliandrome(s.substring(i, j)) || isPaliandrome(s.substring(i + 1, j + 1));
            }
        }
        return true;
    }

    private boolean isPaliandrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _15_ValidPalindromeII test = new _15_ValidPalindromeII();
        boolean flag = test.validPalindrome2("aa");
        System.out.println(flag);
    }
}
