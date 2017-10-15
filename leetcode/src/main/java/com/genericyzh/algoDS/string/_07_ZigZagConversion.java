package com.genericyzh.algoDS.string;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * 将输入的字符串，转换成numRows行的之字形字符串
 * 参考:https://leetcode.com/problems/zigzag-conversion/discuss/
 * 这道题如果再难一点的话，就是要求返回String[]，难点就在于把空格也输出
 *
 * @author genericyzh
 * @date 2017/10/14 23:38
 */
public class _07_ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        if (numRows == 1)
            return s;
        int step1, step2;
        int len = s.length();
        for (int i = 0; i < numRows; ++i) {
            step1 = (numRows - i - 1) * 2; // 下一个下标是列的总数 - 当前是第几列，再*2，最后一行是特殊情况
            step2 = (i) * 2; // 同样的道理，第一行是特殊情况
            int pos = i;
            if (pos < len)
                result.append(s.charAt(pos));
            while (true) {
                pos += step1;
                if (pos >= len)
                    break;
                if (step1 > 0)
                    result.append(s.charAt(pos));
                pos += step2;
                if (pos >= len)
                    break;
                if (step2 > 0)
                    result.append(s.charAt(pos));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        _07_ZigZagConversion zigZagConversion = new _07_ZigZagConversion();
        String result = zigZagConversion.convert("PAYPALISHIRING", 3);
        System.out.println(result);
    }

}
