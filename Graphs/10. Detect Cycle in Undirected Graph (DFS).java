// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// TC = O(N+E)
// SC = O(N)

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
    
    public boolean dfs(int src, int par, boolean[] vis){
        if(vis[src] == true) return true;
        
        vis[src] = true;
        for(int nbr : adj[src]){
            if(nbr == par) continue;
            if(dfs(nbr, src, vis) == true) return true;
        }
        
        return false;
    
    }
}    
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Graph g = new Graph(V);
        boolean[] vis = new boolean[V];
        
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }
        
        for(int idx = 0; idx < V; idx++){
            if(vis[idx] == false && g.dfs(idx , -1, vis) == true){
                    return true;
            } 
        }
        return false;
    }
}




