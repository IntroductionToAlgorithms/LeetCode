package com.leetcode.sort;

import java.util.Arrays;

/**
 * Created by guangoon on 17-5-29.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums.length == 0)
            return ;
        int[] c = new int[3];
        for(int num : nums){
            c[num]++;
        }
        for(int j = 1; j < c.length; j++){
            c[j] += c[j - 1];
        }

        int[] cnums = new int[nums.length];
        System.arraycopy(nums, 0, cnums, 0, nums.length);

        for(int i = cnums.length - 1; i >= 0; i--){
             nums[c[cnums[i]] - 1] = cnums[i];
            c[cnums[i]]--;
        }
    }

    public static void main(String[] args){
        int[] a = {0,1,2,1,2,1,2,1,2,1,2,2};
        SortColors sc = new SortColors();
        sc.sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
