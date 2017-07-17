package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map  = new HashMap<>();
        for(int i : candies){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        if(map.size() > candies.length / 2){
            return candies.length / 2;
        }
        else{
            return map.size();
        }
    }
}
