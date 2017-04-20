package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by guangoon on 17-4-20.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0)
            return false;
        String[] ss = preorder.split(",");
        //System.out.println(Arrays.toString(ss));
        Stack<String> stack = new Stack<String>();
        for(int i = ss.length - 1; i >= 0; i--){
            if(ss[i].equals("#")){
                stack.push(ss[i]);
            }else{
                if(stack.size() < 2)
                    return false;
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return false;
        stack.pop();
        return stack.isEmpty();
    }
}
