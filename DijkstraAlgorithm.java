package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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
     int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist=new int[V];
        Arrays.fill(dist, (int) 1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.first-y.first);
        dist[S]=0;
        pq.add(new Pair(S,0));
       while(!pq.isEmpty()){
           int node=pq.peek().first;
           int dis=pq.peek().second;
           pq.poll();

           for (int i = 0; i <adj.get(node).size() ; i++) {
               int currN=adj.get(node).get(i).get(0);
               int edge=adj.get(node).get(i).get(1);
               if (edge+dis<dist[currN]){
                   dist[currN]=edge+dis;
                   pq.add(new Pair(currN,dist[currN]));
               }
           }
       }

        return dist;
    }
}
