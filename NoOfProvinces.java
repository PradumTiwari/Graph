package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected={{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(isConnected));
    }
//    public static int findCircleNum(int[][] isConnected) {
////Bfs
//        Queue<Integer> q=new LinkedList<>();
//        int[] vis=new int[isConnected.length+1];
//        int count=0;
//
//        for (int i = 1; i <vis.length ; i++) {
//            if (vis[i]==0){
//                q.add(i);
//                vis[i]=1;
//                for (int j = 0; j<isConnected[vis[i-1]].length ; j++) {
//                    if (isConnected[vis[i-1]][j]==1&&j!=i-1){
//                        q.add(j+1);
//                         vis[j+1]=1;
//                    }
//                }
//                count++;
//            }
//        }
//        return count;
//    }

    public static int findCircleNum(int[][] isConnected) {
//Bfs
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i < isConnected.length ; i++) {
            list.add(new ArrayList<>());
        }



        for (int i = 0; i < isConnected.length ; i++) {
            for (int j = 0; j <isConnected.length ; j++) {
                if (isConnected[i][j]==1&&i!=j){

                    list.get(i).add(j);
//                    list.get(j).add(i);
                }
            }
        }
       int list1= noofProvinces(list);
        return list1;
    }
    public static int noofProvinces(ArrayList<ArrayList<Integer>> list){
        Queue<Integer> q=new LinkedList<>();
        int[] vis =new int[list.size()+1];
        int count=0;
        for (int i = 1; i <vis.length ; i++) {
            if (vis[i]==0){
               bfs(i,list,vis);
                count++;
            }
        }
        return count;
    }
    public static void bfs(int V, ArrayList<ArrayList<Integer>> adj,int[] vis) {
        Queue < Integer > q = new LinkedList < > ();

        q.add(V);
        vis[V] = 1;

        while (!q.isEmpty()) {
           int i=q.poll();
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (int j = 0; j <adj.get(i).size() ; j++) {
                if (vis[adj.get(i).get(j)]==0){
                    q.add(vis[adj.get(i).get(j)]);
                    vis[adj.get(i).get(j)]=1;
                }
            }
        }
    }
}
