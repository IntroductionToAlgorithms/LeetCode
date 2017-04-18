package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by guangoon on 17-4-18.
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else{
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
