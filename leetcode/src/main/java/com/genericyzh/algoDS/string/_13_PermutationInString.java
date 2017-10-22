package com.genericyzh.algoDS.string;

/**
 * https://leetcode.com/problems/permutation-in-string/description/
 * 给出两个字符串s1,s2，判断s1的排列是否存在于s2中;题中的输入嗾使26个小写字母，字符串长度为[1,10000]
 * 题中的排列是长度一样的排列，子串不算
 * 如果要符合规定
 * 比较s1 s2相等长度的串，相同字母的数量一样即可
 * <p>
 * How do we know string p is a permutation of string s?
 * Easy, each character in p is in s too. So we can abstract all permutation strings of s to a map (Character -> Count).
 * i.e. abba -> {a:2, b:2}. Since there are only 26 lower case letters in this problem, we can just use an array to represent the map.
 * <p>
 * 参考：https://leetcode.com/problems/permutation-in-string/discuss/
 * How do we know string s2 contains a permutation of s1?
 * We just need to create a sliding window with length of s1, move from beginning to the end of s2.
 * When a character moves in from right of the window, we subtract 1 to that character count from the map.
 * When a character moves out from left of the window, we add 1 to that character count.
 * So once we see all zeros in the map, meaning equal numbers of every characters between s1 and the substring in the sliding window,
 * we know the answer is true.
 *
 * @author genericyzh
 * @date 2017/10/22 23:27
 */
public class _13_PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) {
                return true;
            }
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _13_PermutationInString permutationInString = new _13_PermutationInString();
        String s1 = "abcd";
        String s2 = "abcdefg";
        boolean b = permutationInString.checkInclusion(s1, s2);
        System.out.println(b);
    }

}
