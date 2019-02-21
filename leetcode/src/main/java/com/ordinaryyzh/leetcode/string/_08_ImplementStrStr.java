package com.ordinaryyzh.leetcode.string;

/**
 * https://leetcode.com/problems/implement-strstr/description/
 * 在一个字符串中找子串，如果有就返回原字符串下标，否则返回-1
 *
 * @author genericyzh
 * @date 2017/10/16 21:28
 */
public class _08_ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        // 当前i匹配不上的话，会继续使用i++，i不能跳到j，e.g.aaaa2,aaa2
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = i;
            int k = 0;
            while (j < haystack.length() && k < needle.length()) {
                if (haystack.charAt(j) == needle.charAt(k)) {
                    if (k == needle.length() - 1) {
                        return i;
                    }
                    j++;
                    k++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    /**
     * 另一种写法
     * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72933
     *
     * @param source
     * @param target
     * @return
     */
    public int strStr2(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                } //if
            } //for j
            if (j == target.length()) {
                return i;
            }
        } //for i

        // did not find the target
        return -1;
    }

    /**
     * KMP算法
     * 参考：http://blog.csdn.net/starstar1992/article/details/54913261
     *
     * @param source
     * @param target
     * @return
     */
    public int kmp(String source, String target) {
        if (target.length() > source.length()) {
            return -1;
        }
        if ("".equals(target)) {
            return 0;
        }

        int[] next = new int[target.length()];
        calNext(target, next);//计算next数组
        int slen = source.length();
        int plen = target.length();

        int k = -1;
        for (int i = 0; i < slen; i++) {
            while (k > -1 && target.charAt(k + 1) != source.charAt(i)) {//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
                k = next[k];//往前回溯
            }
            if (target.charAt(k + 1) == source.charAt(i)) {
                k = k + 1;
            }
            if (k == plen - 1)//说明k移动到ptr的最末端
            {
                return i - plen + 1;//返回相应的位置
            }
        }
        return -1;
    }

    private void calNext(String target, int[] next) {
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q <= target.length() - 1; q++) {
            while (k > -1 && target.charAt(k + 1) != target.charAt(q))//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
            {
                k = next[k];//往前回溯
            }
            if (target.charAt(k + 1) == target.charAt(q))//如果相同，k++
            {
                k = k + 1;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
        }
    }

    public static void main(String[] args) {
        _08_ImplementStrStr implementStrStr = new _08_ImplementStrStr();
        int i = implementStrStr.strStr("aaaa2", "aaa2");
        int i2 = implementStrStr.kmp("aaaa2", "aaa2");
//        int i = implementStrStr.strStr("", "");
        System.out.println(i);
        System.out.println(i2);
    }

}
