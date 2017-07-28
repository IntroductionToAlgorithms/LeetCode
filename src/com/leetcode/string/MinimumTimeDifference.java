package com.leetcode.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by guangoon on 7/28/17.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int minDifference = Integer.MAX_VALUE;
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return calDifference(s1,s2);
            }
        });
        for(int i = 1; i < timePoints.size(); i++){
            minDifference = Math.min(minDifference, calDifference(timePoints.get(i), timePoints.get(i - 1)));
        }
        String[] time1 = timePoints.get(0).split(":");
        String[] time2 = timePoints.get(timePoints.size() - 1).split(":");
        int result1 = Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]);
        int result2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
        if(minDifference >= result2 - result1)
            minDifference = result2 - result1;
        if(minDifference >= result1 + 24* 60 - result2)
            minDifference = result1 + 24* 60 - result2;
        return minDifference;
    }

    public int calDifference(String s1, String s2){
        //System.out.println("s1 == " + s1 + ", s2 == " + s2);
        int h1 = Integer.parseInt(s1.substring(0,2));
        int m1 = Integer.parseInt(s1.substring(3));
        int h2 = Integer.parseInt(s2.substring(0,2));
        int m2 = Integer.parseInt(s2.substring(3));
        return h1 * 60 + m1 - (h2 * 60 + m2);
    }
}
