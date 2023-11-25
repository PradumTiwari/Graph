package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_path_in_Undirected_Graph_having_unit_distance {
    public static void main(String[] args) {

    }

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <n; i++) {
adj.add(new ArrayList<>());
        }

        for (int i = 0; i <m ; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist=new int[n+1];
        for (int i = 0; i <dist.length ; i++) {
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
       q.add(src);
       while(!q.isEmpty()){
           int curr=q.poll();
           for (int i = 0; i <adj.get(curr).size() ; i++) {
               if (dist[adj.get(curr).get(i)]>dist[curr]+1){
                   dist[adj.get(curr).get(i)]=dist[curr]+1;
                   q.add(dist[adj.get(curr).get(i)]);
               }
           }
           }

        for (int i = 0; i <n ; i++) {
            if (dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
