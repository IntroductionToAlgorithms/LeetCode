package com.leetcode.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 17-6-12.
 */
public class FindKPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        if(nums1.length == 0 || nums2.length == 0)
            return res;
        return res;
    }

    public static void main(String[] args){
        FindKPairswithSmallestSums fps = new FindKPairswithSmallestSums();
        int[] a = {1,1,2};
        int[] b = {1,2,3};
        List<int[]> res = fps.kSmallestPairs(a,b,10);
        for(int[] in : res){
            System.out.println(in[0] + "：" + in[1]);
        }
    }
}
