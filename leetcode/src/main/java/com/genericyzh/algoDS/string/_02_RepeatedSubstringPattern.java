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
    public boolean repeatedSubstringPattern1(String s) {
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

    /**
     * 超时方法，当时不知道怎么写的...
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; --i) {
            if (n % i == 0) {
                int c = n / i;
                String t = "";
                for (int j = 0; j < c; ++j) {
                    t += s.substring(0, i);
                }
                if (t.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 自己写的
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            if (length % i != 0) {
                continue;
            }
            int l = 0;
            int r = l + i;
            String temp = s.substring(0, i);
            while (r <= length) {
                String compareStr = s.substring(l, r);
                if (!(temp.equals(compareStr))) {
                    break;
                }
                l += i;
                r += i;
            }
            if (r > length) {
                return true;
            }
        }
        return false;
    }

    /**
     * discuss中的代码
     *
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern4(String str) {
        int len = str.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int m = len / i;
                String subS = str.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!subS.equals(str.substring(j * i, i + j * i))) {
                        break;
                    }
                }
                if (j == m) {
                    return true;
                }
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
