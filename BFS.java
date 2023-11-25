package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
MakeAdjList(8);
    }
    public static void MakeAdjList(int n){
       List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
            list.add(new ArrayList<>());
        }
        //adj list of 1
        list.get(1).add(2);
        list.get(1).add(6);

        //adj list of 2
        list.get(2).add(1);
        list.get(2).add(3);
        list.get(2).add(4);

        //adj list of 3
        list.get(3).add(2);

        //adj list of 4
        list.get(4).add(2);
        list.get(4).add(5);

        //adj list of 5
        list.get(5).add(4);
        list.get(5).add(7);

        //adj list of 6
        list.get(6).add(1);
        list.get(6).add(7);
        list.get(6).add(8);

        //adj list of 7
        list.get(7).add(6);
        list.get(7).add(5);
        //adj list of 8
        list.get(8).add(6);
        System.out.println(BfsAnswer(n,list));
    }

    public static String BfsAnswer(int n,List<List<Integer>> list){
        //let starting node is given and that is 6
        String s="";
        int[] vis=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(6);
        vis[6]=1;
        while(!q.isEmpty()){
            int e=q.poll();
            for (int i = 0; i <list.get(e).size() ; i++) {
               int curr=list.get(e).get(i);
               if (vis[curr]!=1){
                   vis[curr]=1;
                   q.add(curr);
               }
            }
            s=s+e;
        }
        return s;
    }
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length ; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        return list;
    }
}
