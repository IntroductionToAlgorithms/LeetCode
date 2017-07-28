package com.leetcode.string;

import java.util.Stack;

/**
 * Created by guangoon on 7/28/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null)
            return false;
        byte[] bs = s.getBytes();
        Stack<Byte> stack = new Stack<Byte>();
        for(int i = 0; i < bs.length; i++){
            if(bs[i] == ')'){
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            }else if(bs[i] == ']'){
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }else if(bs[i] == '}'){
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }else if(bs[i] == '(' || bs[i] == '[' || bs[i] == '{'){
                stack.push(bs[i]);
            }
        }
        return stack.isEmpty();
    }
}
