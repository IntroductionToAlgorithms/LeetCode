package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!maps.containsKey(s.charAt(i))){
                if(mapt.containsKey(t.charAt(i)))
                    return false;
                maps.put(s.charAt(i), t.charAt(i));
                mapt.put(t.charAt(i), s.charAt(i));
            }else{
                if(maps.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
