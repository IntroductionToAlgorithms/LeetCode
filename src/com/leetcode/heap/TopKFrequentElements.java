package com.leetcode.heap;

import java.util.*;

/**
 * Created by guangoon on 17-6-11.
 */
public class TopKFrequentElements {
    class FrequenctElements{
        Integer key;
        Integer count;
        FrequenctElements(Integer key, Integer count){
            this.key = key;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<FrequenctElements> pq = new PriorityQueue<>(new Comparator<FrequenctElements>() {
            @Override
            public int compare(FrequenctElements frequenctElements, FrequenctElements t1) {
                return t1.count.compareTo(frequenctElements.count);
            }
        });

        for(Integer integer : map.keySet()){
            pq.add(new FrequenctElements(integer, map.get(integer)));
        }

        List<Integer> res = new ArrayList<Integer>();

        while(k > 0){
            res.add(pq.poll().key);
            k--;
        }

        return res;
    }
}
