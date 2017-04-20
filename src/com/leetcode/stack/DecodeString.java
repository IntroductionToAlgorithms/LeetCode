package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by guangoon on 17-4-20.
 */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> sStack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']'){
                String tmp = "";
                while(!sStack.isEmpty() && sStack.peek() != '['){
                    char c = sStack.pop();
                    if(!Character.isDigit(c))
                        tmp = c + tmp;
                }
                sStack.pop();
                String snum = "";
                while(!sStack.isEmpty() && Character.isDigit(sStack.peek())){
                    snum =  sStack.pop() + snum;
                }
                //System.out.println("snum == " + snum);
                //System.out.println("tmp == " + tmp);
                int num = 1;
                if(!snum.equals("")){
                    num = Integer.parseInt(snum);
                }
                String stmp = "";
                while(num >= 1){
                    stmp += tmp;
                    num--;
                }
                //System.out.println("stmp == " + stmp);
                for(int j = 0; j < stmp.length(); j++){
                    sStack.push(stmp.charAt(j));
                }
            }else{
                sStack.push(s.charAt(i));
            }
        }
        String result = "";
        while(!sStack.isEmpty()){
            result = sStack.pop() + result;
        }
        return result;
    }
}
