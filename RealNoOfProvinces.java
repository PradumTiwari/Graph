package com.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RealNoOfProvinces {
    public static void main(String[] args) {
 int[][] isConnected = { {1, 0, 1},
         {0, 1, 0},
         {1, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }


    public static int findCircleNum(int[][] isConnected) {
 int size=isConnected.length;
 int[] vis=new int[size+1];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i <=size ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i =1; i <list.size() ; i++) {
            for (int j = 0; j <isConnected[0].length ; j++) {
               if (j+1!=i&&isConnected[i-1][j]!=0){
                   list.get(i).add(j+1);
               }
            }
        }
        int count=0;
      //Now we get the adj list
       Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i < vis.length ; i++) {
            if (vis[i]!=1){
                count++;
                q.add(i);
                vis[i]=1;

                while(!q.isEmpty()){
                    int curr=q.poll();
                    for (int j = 0; j <list.get(curr).size() ; j++) {
                        if (vis[list.get(curr).get(j)]!=1){
                            vis[list.get(curr).get(j)]=1;
                            q.add(list.get(curr).get(j));
                        }
                    }
                }
            }
        }

       return count;
        }
    }

