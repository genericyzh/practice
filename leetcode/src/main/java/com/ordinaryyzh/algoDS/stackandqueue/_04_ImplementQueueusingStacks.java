package com.ordinaryyzh.algoDS.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-stack-using-queues
 *
 * @author OrdinaryYZH
 * @date 2017/10/6 23:29
 */
public class _04_ImplementQueueusingStacks {
    Stack<Integer> stack;
    Stack<Integer> helper;

    /**
     * Initialize your data structure here.
     */
    public _04_ImplementQueueusingStacks() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (helper.isEmpty()) {

            while (!stack.isEmpty()) {
                helper.push(stack.pop());
            }
        }

        return helper.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (helper.isEmpty()) {

            while (!stack.isEmpty()) {
                helper.push(stack.pop());
            }
        }
        return helper.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return helper.isEmpty() && stack.isEmpty();
    }
}
