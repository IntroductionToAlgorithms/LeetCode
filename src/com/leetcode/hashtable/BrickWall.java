package com.leetcode.hashtable;

import java.util.*;

/**
 * Created by guangoon on 7/17/17.
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int maxCount = 0;
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < wall.size(); i++){
            List<Integer> brick = wall.get(i);
            int sum = 0;
            for(int j = 0; j < brick.size() - 1; j++){
                sum += brick.get(j);
                List<Integer> list = map.getOrDefault(sum, new LinkedList<>());
                list.add(i);
                if(list.size() > maxCount)
                    maxCount = list.size();
                map.put(sum, list);
            }
        }
        for(Integer integer : map.keySet()){
            List<Integer> list = map.get(integer);
            System.out.println(Arrays.toString(list.toArray()));
        }
        return wall.size() - maxCount;
    }
}
