package com.genericyzh.algoDS.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * 将一串句子中的单词反转
 *
 * @author genericyzh
 * @date 2017/10/9 23:22
 */
public class _03_ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) return "";

        java.util.StringTokenizer st = new java.util.StringTokenizer(s.trim(), " ");
        List<String> list = new ArrayList<>();
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            sb.append(s1).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String reverseWords2(String s) {
        if (s.length() == 0)
            return "";
        String[] array = s.split(" "); // [, , the, sky]
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            //Notice equals("")
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        _03_ReverseWordsInAString reverseWordsInAString = new _03_ReverseWordsInAString();
        String s = reverseWordsInAString.reverseWords2("  the     sky   ");
//        String s = reverseWordsInAString.reverseWords("  the     sky is blue");
        System.out.println(s);
    }

}
