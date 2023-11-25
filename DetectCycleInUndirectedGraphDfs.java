package com.Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInUndirectedGraphDfs {
    public static void main(String[] args) {

        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <=6 ; i++) {
            adj.add(new ArrayList<>());
        }
        //for 1
        adj.get(1).add(2);
        adj.get(1).add(5);
        //for 2
        adj.get(2).add(3);
        adj.get(2).add(1);
        //for 3
        adj.get(3).add(2);
        adj.get(3).add(4);
        //for 4
        adj.get(4).add(3);
        adj.get(4).add(5);
        //for 5
        adj.get(5).add(1);
        adj.get(5).add(6);
        //for 6
        adj.get(6).add(5);
        System.out.println(detectCycle(6,adj));
    }

   public static boolean detectCycle(int V, List<List<Integer>> adj) {
       int[] vis=new int[V+1];

        for (int i = 1; i <=V ; i++) {
            if (vis[i]==0){
               if (dfs(adj,vis,i,-1)){
                   return true;
               }
            }
       }
        return false;
        // Write your code here.
    }

    public static boolean dfs(List<List<Integer>> adj,int[] vis,int i,int parent){
        vis[i]=1;
        for (int j = 0; j <adj.get(i).size() ; j++) {
            int curr=adj.get(i).get(j);
            if (vis[curr]==0){
                vis[curr]=1;
                if(dfs(adj,vis,curr,i)){
                    return true;
                }
            }
            else if (vis[curr]==1&&curr!=parent) {
       //It means it is not a parent node and is a cycle
                return true;
            }
        }
        return false;
    }



}
