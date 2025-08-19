// Lc 1319
// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

// TC = O(n + e)
// SC = O(n + e)

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

    public void addEdges(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public void dfs(int src, boolean[] vis){
        if(vis[src] == true) return;
        vis[src] = true;
        for( int nbr : adj[src]){
            dfs(nbr, vis);
        }
    }
}


class Solution {

    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length) return -1;
        
        Graph g = new Graph(n);
        for(int edge[] : connections){
            g.addEdges(edge[0], edge[1]);
        }

        boolean[] vis = new boolean[n];
        int components = 0;
        for(int idx = 0; idx < n ; idx++){
            if(vis[idx] != true){
                components++;
                g.dfs(idx, vis);
            }
        }
        return components-1;
    }
    
}
