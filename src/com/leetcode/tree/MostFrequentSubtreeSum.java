package com.leetcode.tree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.Util;

import java.util.*;

/**
 * Created by guangoon on 7/5/17.
 */
public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> sumMap = new HashMap<>();
    private int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
        int sum = getChildSum(root);
        int count = sumMap.getOrDefault(sum, 0) + 1;
        if(count > maxCount)
            maxCount = count;
        sumMap.put(sum,count);

        List<Integer> resl = new ArrayList<>();

        for(Integer key : sumMap.keySet()){
            if(sumMap.get(key) == maxCount){
                resl.add(key);
            }
        }
        int[] res = new int[resl.size()];
        int i  = 0;
        for(Integer integer : resl){
            res[i++] = integer;
        }
        return res;
    }

    public int getChildSum(TreeNode x){
        System.out.println("getChildSum");
        int sum = 0;
        if(x.left != null){
            int left = getChildSum(x.left);
            int count = sumMap.getOrDefault(left, 0) + 1;
            if(count > maxCount)
                maxCount = count;
            sumMap.put(left,count);
            sum += left;
        }
        if(x.right != null){
            int right =  getChildSum(x.right);
            int count = sumMap.getOrDefault(right, 0) + 1;
            if(count > maxCount)
                maxCount = count;
            sumMap.put(right,count);
            sum += right;
        }
        sum += x.val;
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args){
        MostFrequentSubtreeSum mfss = new MostFrequentSubtreeSum();
        String input = "[5,2,-3]";
        TreeNode root = Util.buildTreeNode(input);


        System.out.println(Arrays.toString(mfss.findFrequentTreeSum(root)));
    }
}
