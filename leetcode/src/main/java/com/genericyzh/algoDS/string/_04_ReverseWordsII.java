package com.genericyzh.algoDS.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii
 * 跟上一题题意一样，区别是参数变成了char[] ，并且不能使用额外的空间
 *
 * @author genericyzh
 * @date 2017/10/10 22:59
 */
public class _04_ReverseWordsII {

    public void reverseWords(char[] s) {
        // 首先reverse
        reverse(s, 0, s.length - 1);

        // 碰到空格转换单词
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }

        // 最后的/只有一个单词也要转
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _04_ReverseWordsII reverseWordsInAString = new _04_ReverseWordsII();
//        char[] s = "       sky   ".toCharArray();
        char[] s = "  the     sky is blue".toCharArray();
        reverseWordsInAString.reverseWords(s);
        System.out.println(s);
    }

}
