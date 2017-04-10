package com.leetcode.unionfind;

/**
 * Created by guangoon on 17-4-10.
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int l = M.length;
        int res = l;
        int[] ids = new int[l];
        for(int i = 0; i < l; i++){
            ids[i] = i;
        }
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                if(i != j && M[i][j] == 1){
                    int rootp = find(ids,i);
                    int rootq = find(ids,j);
                    if(rootp == rootq)
                        continue;
                    ids[rootp] = rootq;
                    res--;
                }
            }
        }
        return res;
    }

    public int find(int[] ids,int p) {
        while (p != ids[p])
            p = ids[p];
        return p;
    }

    public static void main(String[] args){
        int[][] M = new int[1000][1000];
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                M[i][j] = 1;
            }
        }
        FriendCircles fc = new FriendCircles();
        System.out.println(fc.findCircleNum(M));
    }
}
