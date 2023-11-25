package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeAndEventualNodes {
    public static void main(String[] args) {
       int[][]  graph = {{1,2},{2,3},{5},{0},{5},{},{}};
       eventualSafeNodes(graph);
    }

    public static void eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] path = new int[graph.length];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <graph.length ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length ; i++) {
            for (int j = 0; j <graph[i].length ; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i,adj,vis,path);
            }
        }
        System.out.println(Arrays.toString(vis));
    }


    public static boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path){
        vis[i]=1;
        path[i]=1;
        for (int j = 0; j <adj.get(i).size() ; j++) {
            if (dfs(adj.get(i).get(j),adj,vis,path)){
                return true;
            }
            else if(path[adj.get(i).get(j)]==1){
                //Not in same path but already visited so need to traverse it more
                return true;
            }
        }
        path[i]=0;
        return false;
    }
}