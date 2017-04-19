package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by guangoon on 17-4-19.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String string: tokens){
            if(string.equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            }else if(string.equals("-")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            }else if(string.equals("*")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
            }else if(string.equals("/")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            }else{
                stack.push(Integer.parseInt(string));
            }
        }
        return stack.pop();
    }
}
