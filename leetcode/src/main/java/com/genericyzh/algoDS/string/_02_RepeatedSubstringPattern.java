package com.genericyzh.algoDS.string;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 * 给出一个字符串，判断其是否能够由子串组成
 *
 * @author genericyzh
 * @date 2017/10/8 23:14
 */
public class _02_RepeatedSubstringPattern {

    /**
     * 不正确的做法
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() <= 1) return false;

        int len = s.length(), mid = len / 2; // half

        if (s.substring(0, mid).equals(s.substring(mid))) return true;

        int one_third = len / 3; // 1/3

        String sub = s.substring(0, one_third);

        if (sub.equals(s.substring(one_third, one_third * 2))
                && sub.equals(s.substring(one_third * 2))) return true;

        if (len % 2 == 1) { // odd number of characters
            char c = s.charAt(0);
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) != c) return false;
            }

            return true;
        }

        return false;
    }

    public boolean repeatedSubstringPattern(String str) {
        int n = str.length();
        for (int i = n / 2; i >= 1; --i) {
            if (n % i == 0) {
                int c = n / i;
                String t = "";
                for (int j = 0; j < c; ++j) {
                    t += str.substring(0, i);
                }
                if (t.equals(str)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _02_RepeatedSubstringPattern repeatedSubstringPattern = new _02_RepeatedSubstringPattern();
        String s = "abcdabcdabcdabcdabcd";
        boolean b = repeatedSubstringPattern.repeatedSubstringPattern(s);
        System.out.println(b);
    }

}
