package com.ordinaryyzh.algoDS.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 * 我的做法，pop的时候，如果另一个为空，那么就把当前的size-1个挪到另一个队列中，否则就先确定要出队列的是哪个，继续留一个
 * push：也要确定是哪个队列
 * 这种做法比较麻烦
 *
 * @author OrdinaryYZH
 * @date 2017/10/5 23:26
 */
public class _03_ImplementStackUsingQueues {
    /**
     * 参考：https://github.com/sherxon/AlgoDS/blob/master/src/problems/easy/ImplementStackUsingQueues.java
     */
    static class MyStack {
        Queue<Integer> q;
        Queue<Integer> temp;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new LinkedList<>();
            temp = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q.isEmpty()) {
                q.add(x);
            } else {
                while (!q.isEmpty()) {
                    // copy all to helper
                    temp.add(q.poll());
                }
                q.add(x); // add element
                while (!temp.isEmpty()) {
                    // copy back all to helper
                    q.add(temp.poll());
                }
            }

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
