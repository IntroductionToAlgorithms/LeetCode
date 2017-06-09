package com.leetcode.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by guangoon on 17-6-9.
 */
public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if(s == null || d.size() == 0)
            return "";
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String aa, String bb) {
                if(aa.length() != bb.length()){
                    return bb.length() - aa.length();
                }
                return aa.compareTo(bb);
            }
        });
        for(String p : d){
            if(s.length() < p.length())
                continue;
            int i = 0, j = 0;
            while(i < s.length() && j < p.length()){
                if(s.charAt(i) == p.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == p.length())
                return p;
        }
        return "";
    }
}
