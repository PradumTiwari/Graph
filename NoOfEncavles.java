package com.Graph;

public class NoOfEncavles 
{
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
    public static int numEnclaves(int[][] grid) {
        int[][] img=grid;
        int rows = grid.length;
        int cols = grid[0].length;
int count=0;
        int[] delrow = {-1, 0, 1, 0}; // Array to represent changes in row index to traverse in all four directions
        int[] delcol = {0, 1, 0, -1}; // Array to represent changes in column index to traverse in all four directions

        int[][] vis = new int[rows][cols];
        // Process first row and last row
        for (int i = 0; i < cols; i++) {
            // Process first row
            if (grid[0][i] == 1&& vis[0][i] == 0) {
                dfs(0, i, grid, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last row
            if (grid[rows - 1][i] == 1 && vis[rows - 1][i] == 0) {
                dfs(rows - 1, i, grid, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
        }

        // Process first and last column
        for (int i = 0; i < rows; i++) {
            // Process first column
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, grid, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
            // Process last column
            if (grid[i][cols - 1] ==1&& vis[i][cols - 1] == 0) {
                dfs(i, cols - 1, grid, vis, delrow, delcol); // Call the dfs method to explore the connected region of 'O's
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]==1&&vis[i][j]==0){
                    count++;
                    vis[i][j]=1;
                }
            }
        }
        return count;
    }
    public static void dfs(int r,int c,int[][] board,int[][] vis,int[] delrow,int[] delcol){
        vis[r][c]=1;

        for (int i = 0; i <4 ; i++) {
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if (nrow>=0&&nrow< board.length&&ncol>=0&&ncol<board[0].length&&board[nrow][ncol]==1 &&vis[nrow][ncol]!=1){
                dfs(nrow,ncol,board,vis,delrow,delcol);
            }
        }
    }
    
}
