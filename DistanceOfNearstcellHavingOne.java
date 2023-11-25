package com.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearstcellHavingOne {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        int[][] img=nearest(grid);
        for (int i = 0; i < grid.length ; i++) {
            System.out.println(Arrays.toString(img[i]));
        }
    }
   static class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public static int[][] nearest(int[][] grid)
    {
        int[][] img=grid;
        int[][] vis=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        int[]  delrow = {0, 0, 1, -1};
        int[] delcol = {1, -1, 0, 0};
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]==1){
                  q.add(new Pair(i,j,0));
                  vis[i][j]=1;
                }
            }
        }
        while (!q.isEmpty()){
            int row=q.peek().r;
            int col=q.peek().c;
            int d=q.peek().d;
            q.poll();
            img[row][col]=d;
            for (int i = 0; i <4 ; i++) {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if (nrow>=0&&nrow<grid.length&&ncol>=0&&ncol<grid[0].length&&vis[nrow][ncol]==0&&img[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    img[nrow][ncol]=d+1;
                    q.add(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return img;
    }
}
