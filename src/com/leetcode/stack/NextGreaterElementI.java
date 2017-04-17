package com.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by guangoon on 17-4-17.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int length = findNums.length;
        int[]result = new int[length];

        Map<Integer,Integer> ms = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!stack.empty() && stack.peek() < nums[i]){
                ms.put(stack.pop(),nums[i]);
            }
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++){
            result[i] = ms.getOrDefault(findNums[i],-1);
        }
        return result;
    }

    public static void main(String[] args){
        NextGreaterElementI ngei = new NextGreaterElementI();
        int[] findNums = {};
        int[] nums = {1,3,4,2};
        System.out.println(Arrays.toString(ngei.nextGreaterElement(findNums,nums)));
    }
}
