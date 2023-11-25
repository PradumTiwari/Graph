package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        //for 2
        adj.get(2).add(3);
        //for 3
        adj.get(3).add(1);
        //for 4
        adj.get(4).add(0);
        adj.get(4).add(1);
        //for 5
        adj.get(5).add(0);
        adj.get(5).add(2);
        System.out.println(Arrays.toString(topoSort(6,adj)));
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] arr=new int[V];
        Stack<Integer> s=new Stack<>();
        int[] vis=new int[V];
        for (int i = 0; i <V ; i++) {
            if (vis[i]==0){
                 dfs(i,vis,adj,s);
            }
        }
        int i=0;
        while(!s.isEmpty()){
            arr[i]=s.pop();
            i++;
        }
        return arr;
    }
    public static void dfs(int i,int[] vis, ArrayList<ArrayList<Integer>> adj,Stack<Integer> s){
        vis[i]=1;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (vis[adj.get(i).get(j)]==0){
                dfs(adj.get(i).get(j),vis,adj,s);
            }
        }
        s.push(i);
    }
}
