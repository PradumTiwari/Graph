package com.Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    public static void main(String[] args) {
int [][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(countDistinctIslands(grid));

    }

  static  class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int[][] img=grid;
        int[][] vis=new int[grid.length][grid[0].length];
        HashSet<ArrayList<Pair>> h=new HashSet<>();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (img[i][j]==1&&vis[i][j]==0){
                    ArrayList<Pair> list=new ArrayList<>();

                   dfs(i,j,vis,img,list,i,j);
                   if (!h.contains(list)){
                       h.add(list);
                   }
                }
            }
        }
        return h.size();
    }

    public static void dfs(int r,int c,int[][] vis,int[][] img,ArrayList<Pair> list,int r1,int c1){
        vis[r][c]=1;

        list.add(new Pair(r-r1,c-c1));
        int[] delrow = {-1, 0, 1, 0}; // Array to represent changes in row index to traverse in all four directions
        int[] delcol = {0, 1, 0, -1}; // Array to represent changes in column index to t
        for (int i = 0; i <4 ; i++) {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if (nrow>=0&&nrow< img.length&&ncol>=0&&ncol<img[0].length&&img[nrow][ncol]==1 &&vis[nrow][ncol]!=1){

                dfs(nrow,ncol,vis,img,list,r1,c1);
            }
        }
    }

}
