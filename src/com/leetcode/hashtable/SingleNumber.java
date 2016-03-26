package com.leetcode.hashtable;

import java.util.HashSet;

/**Given an array of integers, every element appears twice except for one. Find that single one.
 * */
public class SingleNumber {

	public static void main(String[] args) {

	}
	
    public int singleNumber(int[] nums) {
        if(nums.length == 1)
        	return nums[0];
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(set.contains(nums[i])){
        		set.remove(nums[i]);
        	}
        	else{
        		set.add(nums[i]);
        	}
        }
        for(Integer i : set){
        	return i;
        }
        return 0;
    }

}
