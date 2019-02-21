package com.ordinaryyzh.algoDS;

/**
 * @author genericyzh
 * @date 2018/3/29 16:40
 */
public class Test {

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

    public static void main(String[] args) {
        Test test = new Test();
        boolean result = test.repeatedSubstringPattern("abab");
        System.out.println(result);
    }
}
