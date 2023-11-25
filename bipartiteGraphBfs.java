package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraphBfs {
    public static void main(String[] args) {
int V=4;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <V ; i++) {
            adj.add(new ArrayList<>());
        }
        //0
        adj.get(0).add(2);
        adj.get(0).add(3);

        //2
        adj.get(2).add(0);
        adj.get(2).add(3);

        //3
        adj.get(3).add(0);
        adj.get(3).add(2);
        adj.get(3).add(1);

        //1
        adj.get(1).add(3);
        System.out.println(isBipartite(V,adj));
    }
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Queue<Integer> q=new LinkedList<>();
        //1 for green and 0 for yellow
        int[] col=new int[V];
        for (int i = 0; i < col.length; i++) {
            col[i]=-1;
        }
        int [] vis=new int[V];

        for (int i = 0; i <V ; i++) {
            if (vis[i] == 0) {
                q.add(i);
                col[i] = 1;
                vis[i] = 1;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    int color = col[curr];
                    for (int j = 0; j < adj.get(curr).size(); j++) {
                        if (vis[adj.get(curr).get(j)] == 0) {
                            if (color == 0) {
                                col[adj.get(curr).get(j)] = 1;
                            } else {
                                col[adj.get(curr).get(j)] = 0;
                            }
                            q.add(adj.get(curr).get(j));
                            vis[adj.get(curr).get(j)] = 1;
                        } else if (col[adj.get(curr).get(j)] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
         return true;
    }
}
