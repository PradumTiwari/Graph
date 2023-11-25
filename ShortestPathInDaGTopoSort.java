package com.Graph;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Stack;

public class ShortestPathInDaGTopoSort {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }


    public static void main(String[] args) {

    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
      // first lets try to make graph
        for (int i = 0; i < N; i++) {
            ArrayList < Pair > temp = new ArrayList < Pair > ();
            adj.add(temp);
        }
        for (int i = 0; i < edges.length ; i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis=new int[N];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i <N ; i++) {
            if (vis[i]==0){
                toposort(vis,st,i,adj);
            }
        }
        int[] dist=new int[N];
        for (int i = 0; i <N ; i++) {
            dist[i]=(int)(1e9);
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for (int i = 0; i <adj.get(node).size() ; i++) {
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;
                if (dist[node]+wt<dist[v]){
                    dist[v]=wt+dist[node];
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
    public static void toposort(int[] vis, Stack<Integer> st, int i, ArrayList<ArrayList<Pair>> adj){
        vis[i]=1;
        for (int j = 0; j <adj.get(i).size() ; j++) {
            int v=adj.get(i).get(j).first;
            if (vis[i]==0){
                toposort(vis,st,v,adj);
            }
        }
        st.add(i);
    }
}
