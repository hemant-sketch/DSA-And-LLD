// Lc 785
// https://leetcode.com/problems/is-graph-bipartite/description/

// TC = O(N+E)
// SC = O(N)

class Solution {
    public boolean dfs(int src, int color, int[][] adj, int[] vis){
        if(vis[src] != -1){
            if(vis[src] == color) return true;
            else return false;
        }

        vis[src] = color;
        for(int nbr : adj[src]){
            if(dfs(nbr, 1 - color, adj, vis) == false){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int[] vis = new int[n];

        Arrays.fill(vis, -1);

        for(int idx = 0; idx < n; idx++){
            if(vis[idx] != -1) continue;

            if(dfs(idx, 0, adj, vis) == false) 
                return false;
        }
        return true;
        
    }
}

