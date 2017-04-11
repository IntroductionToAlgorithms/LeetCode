package com.leetcode.unionfind;

import java.util.Arrays;

/**
 * Created by guangoon on 17-4-11.
 */
public class NumberofIslands {

    class UF {
        private int[] ids;
        private int count;
        public UF(char[][] grid, int m, int n){
            ids = new int[m * n];
            count = ids.length;
            for(int i = 0; i < ids.length; i++){
                ids[i] = i;
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '0')
                        count--;
                }
            }
        }

        public int find(int p){
            while(p != ids[p])
                p = ids[p];
            return p;
        }

        public void union(int p, int q){
            int rootp = find(p);
            int rootq = find(q);
            if(rootp == rootq)
                return;
            ids[rootp] = rootq;
            count--;
        }

        public boolean connected(int p, int q){
            return find(p) == find(q);
        }

        public int count(){
            //System.out.print(Arrays.toString(ids));
            return count;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(grid, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if(i > 0 && grid[i - 1][j] == '1'){
                        uf.union(i * n + j,(i-1) * n + j);
                    }

                    if(i < m - 1 && grid[i + 1][j] == '1'){
                        uf.union((i+1) * n + j,i * n + j);
                    }

                    if(j > 0 && grid[i][j - 1] == '1'){
                        uf.union(i * n + j,i* n + j - 1);
                    }

                    if(j < n - 1 && grid[i][j + 1] == '1'){
                        uf.union(i* n + j + 1,i * n + j);
                    }
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args){
        char[][] grid =
                {       {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        NumberofIslands nil = new NumberofIslands();
        System.out.print(nil.numIslands(grid));
    }
}
