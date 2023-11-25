package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 5, E = 5;
//        ArrayList<ArrayList<Integer>>adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
    }
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean value=false;
        int[] vis=new int[V];
        Queue<Pair> q=new LinkedList<>();
        for (int i = 0; i <V ; i++) {
            if (vis[i]!=1){
                vis[i]=1;
                q.add(new Pair(i,-1));
                while(!q.isEmpty()){
                    int node=q.peek().first;
                    int next=q.peek().second;
                    q.poll();
                    for (int j = 0; j <adj.get(node).size() ; j++) {
                        if(vis[adj.get(node).get(j)]==next){
                                return true;
                        }
                        else{
                            q.add(new Pair(adj.get(node).get(j),node));
                            vis[j]=1;
                        }
                    }
                }
            }
        }
        return false;
    }
}
