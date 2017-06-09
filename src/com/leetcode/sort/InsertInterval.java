package com.leetcode.sort;

import com.leetcode.util.Interval;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangoon on 17-6-9.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        boolean add = false;
        for(Interval interval : intervals){
            if(interval.end < newInterval.start ){
                res.add(interval);
            } else if(interval.start > newInterval.end){
                if(!add){
                    res.add(newInterval);
                    add = true;
                }
                res.add(interval);
            }else{
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if(!add){
            res.add(newInterval);
        }
        return res;
    }
}
