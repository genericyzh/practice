package com.genericyzh.algoDS.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果插入了一个最小值到队列中，那么出队到这个最小值之前的min都不会变
 * 如果后面有插入了比最小值大的值，那么最小值出队后，min就会变：e.g.5,4,3,2,1,2,3
 *
 * @author genericyzh
 * @date 2017/10/4 23:31
 */
public class _02_QueuewithMinimum {

    Queue<Long> queue = new LinkedList<>();
    LinkedList<Long> mins = new LinkedList<>();

    private void pop() {
        long last = queue.poll();
        if (mins.peek().compareTo(last) == 0) mins.poll();
    }

    private Long min() {
        return mins.peek();
    }

    private void push(long i) {
        queue.add(i);
        if (mins.isEmpty() || mins.peekLast().compareTo(i) <= 0){
            mins.add(i);}
        else {
            while (!mins.isEmpty() && mins.peekLast().compareTo(i) > 0) {
                mins.removeLast();
            }
            mins.add(i);
        }
    }
}
