package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length; i++){
            if(i == ss.length - 1)
                sb.append(reverseString(ss[i]));
            else
                sb.append(reverseString(ss[i]) + " ");
        }
        return sb.toString();
    }

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
