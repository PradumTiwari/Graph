package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {

//        System.out.println((char)(97));


    }
    public static String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        char[] str=new char[K];
        for (int i = 0; i <K ; i++) {
            str[i]=(char)(97+i);
        }
        List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <K ; i++) {
             adj.add(new ArrayList<>());
        }
        for (int i = 0; i <N-1; i++) {
                String str1=dict[i];
                String str2=dict[i+1];
             int length=Math.min(str1.length(),str2.length());
            for (int j = 0; j <length ; j++) {
                if (str1.charAt(j)!=str2.charAt(j)){
                    adj.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
List<Integer> list=topoSort(K,adj);
        String ans="";
        for (int i = 0; i <list.size() ; i++) {
            ans = ans + (char)(i+ (int)('a'));
        }
return ans;
    }
    private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
}
