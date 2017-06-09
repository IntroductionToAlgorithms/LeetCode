package com.leetcode.sort;

import com.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by guangoon on 17-6-9.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        Interval tmp = null;
        for(Interval interval : intervals){
            if(tmp == null) {
                tmp = interval;
                continue;
            }

            if(interval.start > tmp.end){
                res.add(tmp);
                tmp = interval;
            }else if(interval.end > tmp.end){
                tmp.end = interval.end;
            }
        }
        res.add(tmp);

        return res;
    }
}
