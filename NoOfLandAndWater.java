package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfLandAndWater {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        // Code here
     int count=0;
    int n=grid.length;
    int m=grid[0].length;
    int[][] vis=new int[n][m];
        for (int row = 0; row <n ; row++) {
            for (int col = 0; col <m ; col++) {
                if (grid[row][col]=='1'&&vis[row][col]==0){
                    count++;
                    traveral(row,col,vis,grid);
                }
            }
        }
        return count;
    }
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public void traveral(int r, int c, int[][] vis, char[][] grid){

         vis[r][c]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        int n=grid.length;
        int m=grid[0].length;

        while (!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for (int delrow = -1; delrow <=1 ; delrow++) {
                for (int delcol = -1; delcol <=1 ; delcol++) {
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    if (nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]=='1'&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }

    }


}
