package com.leetcode.heap;

import java.util.Arrays;

/**
 * Created by guangoon on 17-6-11.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        MaxPQ pq = new MaxPQ(nums);
        int km = 0;
        while(k > 0){
            km = pq.poll();
            k--;
        }
        return km;
    }

    class MaxPQ {
        private int[] pq;
        private int N;
        public MaxPQ(int[] a){
            pq = a;
            N = a.length - 1;
            for(int k = N / 2; k >= 0; k--)
                sink(k);
            System.out.println(Arrays.toString(a));
        }

        public int left(int k){
            return 2 * k + 1;
        }

        public int right(int k){
            return 2 * k + 2;
        }

        public int root(int k){
            return (k - 1) / 2;
        }

        public void sink(int k){
            while(left(k) <= N){
                int l = left(k);
                if(l + 1 <= N && pq[l] < pq[l + 1])
                    l++;
                if(pq[k] < pq[l])
                    exch(k,l);
                k = l;
            }
        }

        public void swim(int k){
            while(root(k) > 0 && pq[root(k)] < pq[k]){
                exch(k, root(k));
                k = root(k);
            }
        }

        private void exch(int i, int j){
            int tmp = pq[i];
            pq[i] = pq[j];
            pq[j] = tmp;
        }

        public int poll(){
            int k = pq[0];
            exch(0, N);
            N--;
            sink(0);
            return k;
        }


    }

    public static void main(String[] args){
        int[] a = {3,1,2,4};
        KthLargestElementinanArray ke = new KthLargestElementinanArray();
        System.out.println(Arrays.toString(a));
        System.out.println(ke.findKthLargest(a,2));
    }
}
