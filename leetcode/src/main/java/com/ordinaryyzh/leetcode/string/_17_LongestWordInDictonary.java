package com.ordinaryyzh.leetcode.string;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 * 题意：给出一个字符串s和一个字符串List，
 * 问：s能够去掉若干个字符，去掉之后能否在list中找到，如果存在多个，则返回最长字符串，如果长度相等，返回升序排序的第一个字符串
 *
 * @author OrdinaryYZH
 * @date 2018/4/12 16:13
 */
public class _17_LongestWordInDictonary {

    public String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for (String str : d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0)) {
                    max_str = str;
                }
            }
        }
        return max_str;
    }

    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i)) {
                j++;
            }
        }
        return j == x.length();
    }


    public String findLongestWord2(String s, List<String> d) {
        d.sort((w1, w2) -> w1.length() == w2.length() ? w1.compareTo(w2) : w2.length() - w1.length());
        System.out.println(d);

        String max = "";
        for (String word : d) {
            if (containsWord(s, word)) {
                return word;
            }
        }

        return "";
    }

    /**
     * 不知道为啥该方法快点...
     *
     * @param s
     * @param word
     * @return
     */
    private boolean containsWord(String s, String word) {
        int p = -1;
        for (int i = 0; i < word.length(); ++i) {
            p = s.indexOf(word.charAt(i), ++p);
            if (-1 == p) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _17_LongestWordInDictonary longestWordInDictonary = new _17_LongestWordInDictonary();
        String s = "abpcplea";
        List<String> strings = Arrays.asList("ale", "apple", "monkey", "plea");

        List<String> strings1 = Arrays.asList("a", "b", "c");
        String longestWord = longestWordInDictonary.findLongestWord2(s, strings);
        System.out.println(longestWord);
    }

}
