package com.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by guangoon on 17-4-19.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 2 * n; i++){
            int num = nums[i % n];
            while(!stack.isEmpty() && nums[stack.peek()] < num){
                result[stack.pop()] = num;
            }
            if(i < n){
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        NextGreaterElementII ngeii = new NextGreaterElementII();
        int[] a = {5,4,3,2,1};

        System.out.println(Arrays.toString(ngeii.nextGreaterElements(a)));
    }

}
