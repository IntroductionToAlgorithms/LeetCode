package com.leetcode.sort;

import java.util.Arrays;

/**
 * Created by guangoon on 17-5-29.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0)
            return true;
        if(s.length() != t.length())
            return false;
        byte[] ss = s.getBytes();
        byte[] ts = t.getBytes();
        Arrays.sort(ss);
        Arrays.sort(ts);
        for(int i = 0; i < ss.length; i++){
            if(ss[i] != ts[i])
                return false;
        }
        return true;
    }
}
