package com.Graph;

import java.util.List;

public class dfs {
    public static void main(String[] args) {
        int n=8;
    }
    public static List<Integer> dfs(int n,List<List<Integer>> list,int[] vis,List<Integer> ans){
        vis[n]=1;
        ans.add(n);

        for (int i = 0; i < list.get(n).size(); i++) {
            if (vis[list.get(n).get(i)]!=1) {
                dfs(list.get(n).get(i), list, vis, ans);
            }
        }
        return ans;
    }
}
