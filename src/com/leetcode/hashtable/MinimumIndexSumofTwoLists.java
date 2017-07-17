package com.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guangoon on 7/17/17.
 */
public class MinimumIndexSumofTwoLists {
    private int mMinIndex = Integer.MAX_VALUE;
    private List<String> res = new ArrayList<String>();
    public String[] findRestaurant(String[] list1, String[] list2) {
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list2.length; j++){
                if(list1[i].equals(list2[j])){
                    if(i + j == mMinIndex){
                        res.add(list1[i]);
                    }else if(i + j < mMinIndex){
                        res.clear();;
                        res.add(list1[i]);
                        mMinIndex = i + j;
                    }
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
