package com.leetcode.unionfind;

import java.util.Arrays;

/**
 * Created by guangoon on 17-4-16.
 */
class UF{
    private int[] id;
    private int[] sz;
    private int count;
    public UF(int N){
        count = N;
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 0;
        }
    }

    public int getCount(){
        return count;
    }

    public int find(int p){
        while(p != id[p])
        {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    @Override
    public String toString(){
        return Arrays.toString(id);
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}


public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(n*m + 1);
        System.out.println(uf.toString());
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(i * n + j, n * m);
                    }else{
                        if (board[i - 1][j] == 'O') {
                            uf.union(i * n + j, (i - 1) * n + j);
                        }

                        if (board[i + 1][j] == 'O') {
                            uf.union(i * n + j, (i + 1) * n + j);
                        }

                        if (board[i][j - 1] == 'O') {
                            uf.union(i * n + j, i * n + j - 1);
                        }

                        if (board[i][j + 1] == 'O') {
                            uf.union(i * n + j, i * n + j + 1);
                        }
                    }
                }
            }
        }

        System.out.println(uf.toString());
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    if(!uf.connected(i * n + j, n * m))
                        board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args){
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X','X'},
                {'X','O','O','O','O'},
                {'X','X','X','O','X'},
                {'X','O','X','O','X'},
                {'X','O','X','X','X'}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        sr.solve(board);
        for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[0].length; j++){
               System.out.print(board[i][j]);
           }
           System.out.println();
        }
    }
}
