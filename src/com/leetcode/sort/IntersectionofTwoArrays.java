package com.leetcode.sort;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by guangoon on 17-5-29.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Set<Integer> res = new TreeSet<Integer>();
        Arrays.sort(nums1);
        for(int i : nums2){
            if(Arrays.binarySearch(nums1, i) >= 0){
                res.add(i);
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
