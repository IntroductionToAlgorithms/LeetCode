package com.leetcode.dp;

/**
 * Created by guangoon on 12/25/17.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i - 1] + nums[i] > nums[i]){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            if(maxSum < dp[i])
                maxSum = dp[i];
        }
        return maxSum;
    }
}
