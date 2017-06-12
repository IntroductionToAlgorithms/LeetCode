package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Created by guangoon on 17-6-11.
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            pq.add(new Tuple(i,0,matrix[i][0]));
        }

        //System.out.println(pq.size());
        int t = 1;
        while(t++ < k){
            Tuple tuple = pq.poll();
            //System.out.println("==="  + tuple.val);
            if(tuple.y + 1 == matrix.length)
                continue;
            pq.add(new Tuple(tuple.x , tuple.y + 1, matrix[tuple.x][tuple.y + 1]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable{
        int x;
        int y;
        int val;

        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Object o) {
            Tuple t1 = (Tuple)o;
            return this.val - t1.val;
        }
    }
}
