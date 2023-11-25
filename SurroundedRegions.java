package com.Graph;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
//       char [][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
       char [][] board = {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        solve(board);
        for (int i = 0; i < board.length ; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public static void solve(char[][] board) {
        char[][] img=board;
        int rows = board.length;
        int cols = board[0].length;

        int[] delrow = {-1, 0, 1, 0}; // Array to represent changes in row index to traverse in all four directions
        int[] delcol = {0, 1, 0, -1}; // Array to represent changes in column index to traverse in all four directions

        int[][] vis = new int[rows][cols];
        // Process first row and last row
        for (int i = 0; i < cols; i++) {
            // Process first row
            if (board[0][i] == 'O' && vis[0][i] == 0) {
                dfs(0, i, board, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last row
            if (board[rows - 1][i] == 'O' && vis[rows - 1][i] == 0) {
                dfs(rows - 1, i, board, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
        }

        // Process first and last column
        for (int i = 0; i < rows; i++) {
            // Process first column
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last column
            if (board[i][cols - 1] == 'O' && vis[i][cols - 1] == 0) {
                dfs(i, cols - 1, board, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (board[i][j]=='O'&&vis[i][j]==0){
                    board[i][j]='X';
                    vis[i][j]=1;
                }
            }
        }

    }
    public static void dfs(int r,int c,char[][] board,int[][] vis,int[] delrow,int[] delcol){
        vis[r][c]=1;

        for (int i = 0; i <4 ; i++) {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if (nrow>=0&&nrow< board.length&&ncol>=0&&ncol<board[0].length&&board[nrow][ncol]=='O'&&vis[nrow][ncol]!=1){
                dfs(nrow,ncol,board,vis,delrow,delcol);
            }
        }
    }
}
