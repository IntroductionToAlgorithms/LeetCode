package com.leetcode.string;

/**
 * Created by guangoon on 7/28/17.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                if(isPalindromic(s.substring(i,j)))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindromic(String s){
        if(s.length() == 1)
            return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
