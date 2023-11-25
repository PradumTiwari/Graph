package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventualSafeStates {
    public static void main(String[] args) {
 int V=7;
 List<List<Integer>> adj=new ArrayList<>();
        for (int i = 0; i <7 ; i++) {
            adj.add(new ArrayList<>());
        }
 //Adj for 0
        adj.get(0).add(1);
        adj.get(0).add(2);
        //for 1
        adj.get(1).add(2);
        adj.get(1).add(3);
        //for 2
        adj.get(2).add(5);
        //for 3
        adj.get(3).add(0);
        //for 4
        adj.get(4).add(5);

    }



}



