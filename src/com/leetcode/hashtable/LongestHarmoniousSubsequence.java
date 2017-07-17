package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int res = 0;
        for(Integer integer : map.keySet()){
            if(map.containsKey(integer + 1)){
                res = Math.max(res, map.get(integer) + map.get(integer + 1));
            }
        }
        return res;
    }
}
