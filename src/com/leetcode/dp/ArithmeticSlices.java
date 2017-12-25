package com.leetcode.dp;

/**
 * Created by guangoon on 12/25/17.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;
        int dupCount = 0;
        int dupValue = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 1; i < A.length; i++){
            if(A[i] - A[i - 1] == dupValue){
                dupCount++;
            }else{
                for(int j = 2; j <= dupCount; j++){
                    sum += dupCount - j + 1;
                }
                dupValue = A[i] - A[i - 1];
                dupCount = 1;
            }
        }

        for(int j = 2; j <= dupCount; j++){
            sum += dupCount - j + 1;
        }
        return sum;
    }
}
