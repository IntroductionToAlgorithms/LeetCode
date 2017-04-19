package com.leetcode.stack;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> p = new Stack<Integer>();
    private Stack<Integer> q = new Stack<Integer>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        p.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(q.isEmpty()){
            while(!p.isEmpty()){
                q.push(p.pop());
            }
        }
        return q.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(q.isEmpty()){
            while(!p.isEmpty()){
                q.push(p.pop());
            }
        }
        return q.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return p.isEmpty() && q.isEmpty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */