package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();

        int begin = 0;
        int end = chars.length - 1;
        while(begin < end){
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
        return new String(chars);
    }
}
