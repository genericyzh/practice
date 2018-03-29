package com.genericyzh.algoDS.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * 给出一个只有小写字母的字符串，返回第一个没有重复的字母的下标
 *
 * @author genericyzh
 * @date 2017/10/7 21:38
 */
public class _01_FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new _01_FirstUniqueCharacterInAString().firstUniqChar("loveleetcode"));
    }

}
