package com.ordinaryyzh.algoDS.algo.sortingandsearching;

import java.util.Arrays;

/**
 * 计数排序
 * https://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/72918
 * 维基上总结的四个步骤如下：
 * <p>
 * 1.定新数组大小——找出待排序的数组中最大和最小的元素
 * 2.统计次数——统计数组中每个值为i的元素出现的次数，存入新数组C的第i项
 * 3.对统计次数逐个累加——对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * 4.反向填充目标数组——将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 * 其中反向填充主要是为了避免重复元素落入新数组的同一索引处。
 * <p>
 * 不用反向填充也一样，count[]--就可以了
 * 图解：https://www.cs.usfca.edu/~galles/visualization/CountingSort.html
 *
 * @author genericyzh
 * @date 2017/9/29 21:00
 */
public class _04_CountingSort {

    public static void sort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++)
            max = Math.max(a[i], max);
        max += 1;

        int[] count = new int[max];
        for (int i = 0; i < a.length; i++)
            count[a[i]]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        int[] sorted = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int index = count[a[i]];
            sorted[index - 1] = a[i];
            count[a[i]]--;
        }
        System.out.print(Arrays.toString(sorted));
        System.out.println();
    }

}
