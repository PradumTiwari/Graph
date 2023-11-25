package com.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DijkstraWithSet {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
     int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist=new int[V];
        for (int i = 0; i <V ; i++) {
            dist[i]=(int)1e9;
        }
        dist[S]=0;
        Set<Pair> s=new HashSet<Pair>();
        s.add(new Pair(S,0));
        while(!s.isEmpty()){
            int curr=s.
        }
    }
}
