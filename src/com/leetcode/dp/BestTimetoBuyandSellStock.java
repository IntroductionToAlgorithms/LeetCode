package com.leetcode.dp;

/**
 * Created by guangoon on 12/25/17.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxProfit = 0;
        for (int k = 1; k < prices.length; k++) {
            if (prices[k] - prices[minIndex] > maxProfit)
                maxProfit = prices[k] - prices[minIndex];
            if (prices[k] < prices[minIndex])
                minIndex = k;
        }
        return maxProfit;
    }
}
