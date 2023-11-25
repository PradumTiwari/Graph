package com.Graph;

import java.util.*;

public class KahnsAlgorithm {
    public static void main(String[] args) {
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            adj.add(new ArrayList<>());
        }
        //for 5
        adj.get(5).add(0);
        adj.get(5).add(2);
        //for 4
        adj.get(4).add(0);
        adj.get(4).add(1);
        //for 3
        adj.get(3).add(1);
        //for 2
        adj.get(2).add(3);
        int[] indegree=new int[6];
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <adj.get(i).size() ; j++) {
                indegree[adj.get(i).get(j)]=indegree[adj.get(i).get(j)]+1;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        System.out.println(Arrays.toString(Kahn(indegree,adj,q)));
    }

    public static int[] Kahn(int[] indegree, List<List<Integer>> adj, Queue<Integer> q){
        for (int i = 0; i <indegree.length ; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        int[] vis=new int[6];
        int[] topo=new int[6];
        int k=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            vis[curr]=1;
            topo[k]=curr;
            for (int i = 0; i <adj.get(curr).size() ; i++) {
               indegree[adj.get(curr).get(i)]=indegree[adj.get(curr).get(i)]-1;
            }
            for (int i = 0; i <6 ; i++) {
                if (indegree[i]==0&&vis[i]==0){
                    q.add(i);
                }
            }
        }

return topo;
    }
}
