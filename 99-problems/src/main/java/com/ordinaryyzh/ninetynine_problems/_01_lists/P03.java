package com.ordinaryyzh.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the Kth element of a list.
 * 查询第k个元素
 */
public class P03 {

    /**
     * 传统做法，效率不一定高
     * @param list
     * @param k
     * @param <T>
     * @return
     */
    public static <T> T kth(final List<T> list, final int k) {
        return list.get(k);
    }

    /**
     * 递归做法，效率也不高
     * 递归k次，就可以得到第k个
     * @param list
     * @param k
     * @param <T>
     * @return
     */
    public static <T> T kthRecursive(final LinkedList<T> list, final int k) {
        if (k == 0) {
            return list.getFirst();
        }
        return kthRecursive(new LinkedList<>(list.subList(1, list.size())), k - 1);
    }

    public static <T> T kthStream(final List<T> list, final int k) {
        return list.stream().limit(k + 1).collect(Collectors.toCollection(LinkedList::new)).getLast();
    }

}
