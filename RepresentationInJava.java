package com.Graph;

import java.util.ArrayList;

public class RepresentationInJava {
    public static void main(String[] args) {
        //Graph can be stored in two ways in  a data structure either in matrix format or in adjacency list format
        //for example a graph of 5 nodes of 1 based indexing is given so
        int n=3;
//     matrixRepresentation(n);
     //as a resiult it is a costly operation
        adjacencyList(n);

    }

    private static void adjacencyList(int n) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        //n+1 array list
        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }
        //edge 1-2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 1----3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //print all the edges
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <adj.get(i).size() ; j++) {
                System.out.println(adj.get(i).add(j)+" ");
            }
            System.out.println();
        }
    }

    public static void matrixRepresentation(int n){
        int[][] matrix=new int[n+1][n+1];
        //As it is undirectional so we have to make it store on both direction
        //Edge 1,2
        matrix[1][2]=1;
        matrix[2][1]=1;
        //Edge 1,3
        matrix[1][3]=1;
        matrix[3][1]=1;
        //edge 3,4
        matrix[3][4]=1;
        matrix[4][3]=1;
        //edge 4,2
        matrix[4][2]=1;
        matrix[2][4]=1;
        //edge 4,5
        matrix[4][5]=1;
        matrix[5][4]=1;
        //edge 2,5
        matrix[2][5]=1;
        matrix[5][2]=1;
        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
