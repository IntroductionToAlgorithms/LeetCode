package com.leetcode.dp;

/**
 * Created by guangoon on 12/25/17.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] rets = new int[num + 1];
        for(int i = 0; i <= num; i++){
            rets[i] = getBits(i);
        }
        return rets;
    }

    private int getBits(int num){
        int ret = 0;
        while(num > 0){
            ret++;
            num &= (num - 1);
        }
        return ret;
    }
}
