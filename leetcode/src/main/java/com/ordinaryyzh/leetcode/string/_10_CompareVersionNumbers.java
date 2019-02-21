package com.ordinaryyzh.leetcode.string;

/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 * 比较两个版本号version1和version2。
 * <p>
 * 如果version1 > version2返回1，如果version1 < version2返回-1，否则返回0.
 * <p>
 * 你可以假设版本号字符串均非空并且只包含数字和点号。
 * <p>
 * 点号不代表数字的小数点，用来分割数字序列。
 *
 * @author genericyzh
 * @date 2017/10/18 23:12
 */
public class _10_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int len = Math.max(split1.length, split2.length);

        for (int i = 0; i < len; i++) {
            Integer v1 = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            Integer v2 = i < split2.length ? Integer.parseInt(split2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /**
     * 纯操作写法，没用啥API
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion2(String version1, String version2) {
        char[] cs1 = version1.toCharArray();
        char[] cs2 = version2.toCharArray();

        int i1 = 0, i2 = 0;
        while (i1 < cs1.length || i2 < cs2.length) {
            int n1 = 0;
            while (i1 < cs1.length && cs1[i1] != '.') {
                n1 = n1 * 10 + (cs1[i1++] - '0');
            }
            i1++;
            int n2 = 0;
            while (i2 < cs2.length && cs2[i2] != '.') {
                n2 = n2 * 10 + (cs2[i2++] - '0');
            }
            i2++;
            if (n1 > n2) {
                return 1;
            }
            if (n1 < n2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _10_CompareVersionNumbers compareVersionNumbers = new _10_CompareVersionNumbers();
        int i = compareVersionNumbers.compareVersion("1.2.3.1", "1.2.3");
        System.out.println(i);
    }

}
