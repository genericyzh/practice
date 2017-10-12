package com.genericyzh.algoDS.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/gouthampradhan/leetcode/blob/master/problems/src/string/TextJustification.java
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
            while (j < length && len + 1 + words[j].length() < maxWidth) {
                len += 1 + words[j++].length();
            }

            String line = words[i];
            if (j == length) {
                for (int k = i; k < j; k++) {
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
                        if (k - i < extraWhite % white) {
                            line += " ";
                        }
                        line += words[k];
                    }
                }
                result.add(line);
                i = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _06_TextJustification textJustification = new _06_TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = textJustification.fullJustify(words, 16);
        System.out.println(strings);
    }

}
