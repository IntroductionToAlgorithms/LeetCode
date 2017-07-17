package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guangoon on 7/17/17.
 */
public class ＿4SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> mapAB = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                mapAB.put(A[i] + B[j],mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int cnt = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                cnt += mapAB.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return cnt;
    }
}
