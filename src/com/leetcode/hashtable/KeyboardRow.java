package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] rows = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows[i].length(); j++){
                map.put(rows[i].charAt(j), i);
            }
        }

        List<String> res = new LinkedList<>();
        for(String string : words){
            int index = -1;
            for(int j = 0; j < string.length(); j++){
                if(index == -1){
                    index = map.get(Character.toUpperCase(string.charAt(j)));
                    continue;
                }
                //System.out.println(index);
                if(index != map.get(Character.toUpperCase(string.charAt(j)))){
                    index = -1;
                    break;
                }
            }

            if(index != -1)
                res.add(string);
        }
        return res.toArray(new String[0]);
    }
}
