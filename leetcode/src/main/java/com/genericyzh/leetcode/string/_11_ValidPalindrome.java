package com.genericyzh.leetcode.string;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * 给出一个字符串，判断是否回文，忽略该字符串的空格，逗号之类的，只看其数字， 字母
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * @author genericyzh
 * @date 2017/10/19 23:04
 */
public class _11_ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; i++, j--) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && j > i) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _11_ValidPalindrome validPalindrome = new _11_ValidPalindrome();
//        boolean palindrome = validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
//        boolean palindrome = validPalindrome.isPalindrome("race a car");
        boolean palindrome = validPalindrome.isPalindrome(".,");
        System.out.println(palindrome);
    }
}
