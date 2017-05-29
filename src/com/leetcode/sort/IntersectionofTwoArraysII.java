package com.leetcode.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guangoon on 17-5-29.
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[0];
        List<Integer> res = new LinkedList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : nums1){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        for(int j : nums2){
            if(map.getOrDefault(j, 0) > 0){
                res.add(j);
                map.put(j,map.getOrDefault(j,0) - 1);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for(Integer integer : res) {
            result[i++] = integer;
        }
        return result;
    }
}
