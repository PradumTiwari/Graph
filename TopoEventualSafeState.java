package com.Graph;

import java.util.*;

public class TopoEventualSafeState {
    public static void main(String[] args) {

    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis=new int[graph.length];
    int[] indegree=new int[graph.length];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i < graph.length ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length ; i++) {
            for (int j = 0; j <graph[i].length ; j++) {
                list.get(j).add(i);//reversed the edges
            }
        }
        for (int i = 0; i <graph.length ; i++) {
            for (int j = 0; j <list.get(i).size() ; j++) {
                indegree[list.get(i).get(j)]=indegree[list.get(i).get(j)]+1;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list1=new ArrayList<>();
        for (int i = 0; i <indegree.length ; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            vis[curr]=1;
            list1.add(curr);
            for (int i = 0; i <list.get(curr).size() ; i++) {
                indegree[list.get(curr).get(i)]=indegree[list.get(curr).get(i)]-1;
            }
            for (int i = 0; i <indegree.length ; i++) {
                if (indegree[i]==0&&vis[i]==0){
                    q.add(indegree[i]);
                }
            }
        }
        Collections.sort(list1);
        return list1;
    }
  public static  List<Integer> eventualSafeNodes1( int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int j = 0; j < graph[i].length ; j++) {
                adjRev.get(graph[j][i]).add(graph[i][j]);
                indegree[i]++;
            }

            }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
