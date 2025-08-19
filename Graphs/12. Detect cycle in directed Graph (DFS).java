// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

// TC = O(N+E)
// SC = O(N+E)

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
        // adj[dest].add(src); only in undirected graph bhaiiiiiiiiiiiiiiii
    }
    
    public boolean dfs(int src, int[] vis){
        if(vis[src] == 1) return true;
        if(vis[src] == 2) return false;
        
        vis[src] = 1;
        for(int nbr : adj[src]){
            if(dfs(nbr, vis) == true){
                return true;
            }
        }
        vis[src] = 2;
        return false;
    }   
}   

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Graph g = new Graph(V);
        int[] vis = new int[V];
        
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }
        
        for(int idx = 0; idx < V; idx++){
            if(vis[idx] > 0) continue;
            if(g.dfs(idx, vis) == true) return true;
        }
        return false;
        
    }
}
