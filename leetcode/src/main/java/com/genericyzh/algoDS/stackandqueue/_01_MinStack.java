package com.genericyzh.algoDS.stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 *
 * @author genericyzh
 * @date 2017/10/3 22:56
 */

/**
 * 省了第二个栈的一点空间
 */
public class _01_MinStack {
    private Stack<Integer> stack;

    /**
     * 辅助栈是一个记录当前栈最小值的栈，是一个降序序列
     */
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */

    public _01_MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // isEmpty是首次加入时，只有当小于才加入，所以是一个升序栈
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int p = stack.pop();
        // 只有最小值pop，才会更新辅助栈的栈顶
        if (min.peek() == p) {
            min.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
