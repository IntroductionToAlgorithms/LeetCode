package com.leetcode.dp;

/**
 * Created by guangoon on 12/25/17.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a=0, b=0, c = 0;
        for(int i=2;i<=cost.length;i++){
            c = Math.min(b+cost[i-1], a+cost[i-2]);
            a = b;
            b = c;
        }
        return c;
    }
}
