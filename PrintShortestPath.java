package com.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrintShortestPath {
    public static void main(String[] args) {

    }
    class Pair{
        int first;
        int second;
        Pair(int dis,int node){
            this.first=dis;
            this.second=node;
        }
    }
    public ArrayList<Integer> printShortesPath(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s){
        //
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)->x.first-y.first);

        int[] dist=new int[V];
        dist[s]=0;
        for (int i = 0; i <V ; i++) {
            dist[i]=(int)1e9;
        }

        int[] parent=new int[V];
        for (int i = 0; i <V ; i++) {
            parent[i]=i;
        }
        pq.add(new Pair(0,s));

        while(!pq.isEmpty()){
            int node=pq.peek().second;
            int distance=pq.peek().first;

            for (int i = 0; i <adj.get(node).size() ; i++) {
               int wt=adj.get(node).get(i).get(1);
               int curr=adj.get(node).get(i).get(0);
               if (wt+distance<dist[curr]){
                   dist[curr]=wt+distance;
                   pq.add(new Pair(dist[curr],curr));
                   parent[curr]=node;
               }
            }
        }
        //Method to fetch the node from the resultant parent and the child
        
    }
}
