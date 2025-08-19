// https://www.geeksforgeeks.org/problems/mother-vertex/1

// TC = O(N+E)
// SC = O(N+E)

class Solution {
    
    int[] topo;
    int idx;
    ArrayList<ArrayList<Integer>> adj;
    
    public void dfs(int src, boolean[] vis){
        if(vis[src] == true) return;
        
        vis[src] = true;
        for(Integer nbr : adj.get(src)){
            dfs(nbr, vis);
        }
        
        topo[idx--] = src;
    }
    // Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        this.adj = adj;
        this.idx = V-1;
        this.topo = new int[V];
        
        boolean[] vis = new boolean[V];
        for(int idx = 0; idx < V; idx++){
            dfs(idx, vis);
        }
        
        vis = new boolean[V];
        idx = V - 1;
        dfs(topo[0], vis);
        
        for(int idx = 0; idx < V; idx++){
            if(vis[idx] == false) return -1;
        }
        
        return topo[0];
        
    }
}
