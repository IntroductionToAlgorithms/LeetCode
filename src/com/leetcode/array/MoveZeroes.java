package com.leetcode.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 */

public class MoveZeroes {
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 3, 12};
		moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void moveZeroes(int[] nums) {
		if (nums == null)
			return;
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			while (i < j && nums[i] != 0) {
				i++;
			}

			while (i < j && nums[j] == 0) {
				j--;
			}

			if (i >= j)
				break;
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		System.out.println(i);
	}
}
