package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by guangoon on 17-4-24.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        System.out.println(Arrays.toString(paths));
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < paths.length; i++){
            if(paths[i].trim().length() > 0){
                if(paths[i].trim().equals(".")){

                }else if(paths[i].trim().equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }else{
                    stack.push(paths[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        if(sb.length()<= 0)
            sb.append("/");
        return sb.toString();
    }
}
