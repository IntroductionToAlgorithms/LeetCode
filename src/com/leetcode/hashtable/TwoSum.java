package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   You may assume that each input would have exactly one solution.

   Example:
   Given nums = [2, 7, 11, 15], target = 9,
   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length < 2)
        	return res;
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(map.containsKey(nums[i])){
        		res[0] = map.get(nums[i]);
        		res[1] = i;
        		return res;
        	}
        	map.put(target - nums[i], i);
        }
        return res;
    }
    
    public static void main(String[] args) {
		
	}
}
