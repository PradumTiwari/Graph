package com.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathDaGPractice {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i = 0; i <N ; i++) {
         adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length ; i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        //Now we haveour adj list maded
        int[] vis=new int[N];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i <vis.length; i++) {
            if (vis[i]==0){
                topoSort(i,vis,adj,st);
            }
        }
        int[] dist=new int[N];
        for (int i = 0; i <N ; i++) {
            dist[i]=(int)(1e9);
        }
        dist[0]=0;

        while(st.isEmpty()){
            int node=st.pop();
            for (int i = 0; i <adj.get(node).size() ; i++) {
                int first=adj.get(node).get(i).first;
                int distance=dist[i];
                if (first+distance<dist[adj.get(node).get(i).first]){
                    dist[first]=first+distance;
                }
            }
        }
        for (int i = 0; i <N ; i++) {
            if (dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
    public static void topoSort(int i,int[] vis,ArrayList<ArrayList<Pair>> adj,Stack<Integer> st){
        vis[i]=1;
        for (int j = 0; j <adj.get(i).size() ; j++) {
         int v=adj.get(i).get(j).first;
         if (vis[v]==0){
             topoSort(v,vis,adj,st);
         }
        }
        st.add(i);
    }
}
