package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        if(s.length() <= 1)
            return s;
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while(start < end){
            char lowStart = Character.toLowerCase(chars[start]);
            char lowEnd = Character.toLowerCase(chars[end]);
            if(lowStart != 'a' && lowStart != 'e' && lowStart != 'i' && lowStart != 'o' && lowStart != 'u'){
                start++;
                continue;
            }

            if(lowEnd != 'a' && lowEnd != 'e' && lowEnd != 'i' && lowEnd != 'o' && lowEnd != 'u'){
                end--;
                continue;
            }

            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
        return new String(chars);
    }
}
