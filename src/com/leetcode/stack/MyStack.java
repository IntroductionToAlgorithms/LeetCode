package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by guangoon on 17-4-18.
 */
public class MyStack {
    private Queue<Integer> p = new LinkedList<Integer>();
    private Queue<Integer> q = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(p.isEmpty()){
            p.offer(x);
            for(int i = 0; i < q.size(); i++){
                p.offer(q.poll());
            }
        }else{
            q.offer(x);
            for(int i = 0; i < p.size();i++){
                q.offer(p.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(p.isEmpty()){
            return q.poll();
        }else{
            return p.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if(p.isEmpty()){
            return q.peek();
        }else{
            return p.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return p.isEmpty() && q.isEmpty();
    }
}