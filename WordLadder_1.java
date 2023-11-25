package com.Graph;

import java.util.*;

public class WordLadder_1 {
    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord,String[] wordList) {
        Set<String> st=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        int len=wordList.length;
        for (int i = 0; i <len; i++) {
            st.add(wordList[i]);
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String curr=q.peek().first;
            int steps=q.peek().second;
            q.poll();
            if (curr.equals(endWord)){return steps;}
            for (int i = 0; i <curr.length() ; i++) {
                for (char j ='a' ; j <='z' ; j++) {
                    char[] arr=curr.toCharArray();
                    arr[i]=j;
                    String newWord=new String(arr);
                    if (st.contains(newWord)){
                        q.add(new Pair(newWord,steps+1));
                        st.remove(newWord);
                    }
                }
            }
        }
return 0;
    }
}
