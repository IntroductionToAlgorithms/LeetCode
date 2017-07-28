package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        if(s.length() == 1){
            result += getData(s.charAt(0));
        }
        for(int i = 1; i < s.length();){
            int pre = getData(s.charAt(i - 1));
            int cur = getData(s.charAt(i));
            if(cur <= pre){
                result += pre;
                i++;
                if(i == s.length()){
                    result += cur;
                }
            } else if(cur > pre){
                result += (cur - pre);
                i+= 2;
                if(i == s.length()){
                    result += getData(s.charAt(i - 1));
                }
            }
        }
        return result;
    }

    public int getData(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
