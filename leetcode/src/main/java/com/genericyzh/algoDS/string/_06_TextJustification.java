package com.genericyzh.algoDS.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/gouthampradhan/leetcode/blob/master/problems/src/string/TextJustification.java
 * 题意：把一个集合的单词按照每行maxWidth个字符放，每行要两端对齐，如果空格不能均匀分布在所有间隔中，
 * 那么左边的空格要多于右边的空格，最后一行靠左对齐，空格补全。
 *
 * @author genericyzh
 * @date 2017/10/12 23:32
 */
public class _06_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int length = words.length;
        while (i < length) {
            int j = i + 1;
            int len = words[i].length();
            while (j < length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j++].length();
            }

            String line = words[i];
            if (j == length) { // 最后一行
                for (int k = i + 1; k < length; k++) {
                    line += " " + words[k];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
            } else {
                int extraWhite = maxWidth - len;
                int white = j - i - 1;
                if (j - i == 1) { // 一行只有一个单词
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        line += " ";
                        for (int l = 0; l < extraWhite / white; l++) {
                            line += " ";
                        }
                        if (k - i <= extraWhite % white) {
                            line += " ";
                        }
                        line += words[k];
                    }
                }
            }
            result.add(line);
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        _06_TextJustification textJustification = new _06_TextJustification();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"Here", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {""};
        List<String> strings = textJustification.fullJustify(words, 16);
        System.out.println(strings);
    }

}
