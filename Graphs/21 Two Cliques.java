// https://www.naukri.com/code360/problems/two-cliques_1214524

// TC = O(N+E)
// TC = O(N+E)

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph(int n){
        this.n = n;
        adj = new ArrayList[n];
        for(int idx = 0; idx < n; idx++){
            adj[idx] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public boolean dfs(int src, int color, int[] vis){
        if(vis[src] != -1){
            if(vis[src] == color) return true;
            else return false;
        }

        vis[src] = color;
        for(int nbr : adj[src]){
            if(dfs(nbr, 1 - color, vis) == false) return false;
        }
        return true;
    }
}
public class Solution {
    public static boolean twoCliques(int n, ArrayList<ArrayList<Integer>> edgeList) {
        // Write your code here
        boolean[][] mat = new boolean[n][n];
        for(ArrayList<Integer> edge : edgeList){
            mat[edge.get(0)][edge.get(1)] = true;
            mat[edge.get(1)][edge.get(0)] = true;
        }

        Graph rev = new Graph(n);
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                if(row != col && mat[row][col] == false){
                    rev.addEdge(row, col);
                }
            }
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for(int idx = 0; idx < n; idx++){
            if(vis[idx] != -1) continue;
            if(rev.dfs(idx, 0, vis) == false){
                return false;
            }
        }
        return true;
    }
}
