package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int evenCount = 0;
        for(Character character : map.keySet()){
            evenCount += map.get(character) / 2;
        }

        if(evenCount * 2 == s.length()){
            return evenCount * 2;
        }
        else{
            return evenCount * 2 + 1;
        }
    }
}
