package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleInDirected {
    public static void main(String[] args) {
        int V=3;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < V ; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);

//        adj.get(2).add(3);
//        adj.get(3).add(3);
        System.out.println( isCyclic(V,adj));
    }
    public static boolean isCyclic(int V,ArrayList<ArrayList<Integer>> adj) {
        // code here
    int[] vis=new int[V];
   int[] path=new int[V];

        for (int i = 0; i <V ; i++) {
            if (vis[i]==0){
                if (dfs(i,adj,vis,path)==true)return true;
            }
        }
        System.out.println(Arrays.toString(vis));
        System.out.println(Arrays.toString(path));
return false;
    }
    public static boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] path){
        vis[i]=1;
        path[i]=1;
        for (int j = 0; j <adj.get(i).size() ; j++) {
            if (dfs(adj.get(i).get(j),adj,vis,path)==true){
                return true;
            }
            else if(path[adj.get(i).get(j)]==1){
                return true;
            }
        }
        path[i]=0;
       return false;
    }
}
