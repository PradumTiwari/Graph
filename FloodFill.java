package com.Graph;

import javax.sound.midi.MidiFileFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int[][] arr=floodFill(image,sr,sc,color);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(arr[0]));

        }
    }
static class Pair{
        int first;
        int second;
       public Pair(int first,int second){
           this.first=first;
           this.second=second;
       }
}
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
// first lets do it by bfs
        int[][] img1=image;//made the copied array
        int[][] vis=new int[image.length][image[0].length];
        int ans=image[sr][sc];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc]=1;
        img1[sr][sc]=color;
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};
        while(!q.isEmpty()) {
            for (int i=0;i<4;i++) {
                int neigrow = sr + delRow[i];
                int neigcol = sc + delCol[i];
                if (neigrow >= 0 && neigrow < image.length && neigcol >= 0 && neigcol < image[0].length && image[neigrow][neigcol] == ans && vis[neigrow][neigcol] == 0) {
                    vis[neigrow][neigcol] = 1;
                    img1[neigrow][neigcol] = color;
                    q.add(new Pair(neigrow, neigcol));

                }
                q.poll();
            }
        }
          return img1;
    }

}
