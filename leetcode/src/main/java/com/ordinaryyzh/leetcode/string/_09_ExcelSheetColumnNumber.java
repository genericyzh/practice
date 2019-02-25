package com.ordinaryyzh.leetcode.string;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * @author OrdinaryYZH
 * @date 2017/10/17 22:26
 */
public class _09_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = c - 'A' + 1;
            result += n * Math.pow(26, (s.length() - i - 1));
        }
        return result;
    }

    /**
     * 更好的写法
     *
     * @param s
     * @return
     */
    public int titleToNumber2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) % 64); //or  s.charAt(i) - 'A' + 1
        }
        return result;
    }

    public static void main(String[] args) {
        _09_ExcelSheetColumnNumber excelSheetColumnNumber = new _09_ExcelSheetColumnNumber();
        int result = excelSheetColumnNumber.titleToNumber("ZZ");
        System.out.println(result);
    }

}
