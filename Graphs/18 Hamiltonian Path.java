// https://www.geeksforgeeks.org/problems/hamiltonian-path2522/1

// TC = Exponential
// SC = O(N+E)

// User function Template for Java
class Graph{
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
}    
class Solution {
    
    public int countVisited(boolean[] vis){
        int count = 0;
        for(boolean v : vis){
            if(v == true) count++;
        }
        return count;
    } 
    public boolean dfs(int src, Graph g, boolean[] vis){
        if(vis[src] == true) return false;
        
        vis[src] = true;
        if(countVisited(vis) == g.n) return true;
        
        for(int nbr : g.adj[src]){
            if(dfs(nbr, g, vis) == true) return true;
        }
        
        vis[src] = false;
        return false;
    }
    
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // code here
        Graph g = new Graph(n);
        for(ArrayList<Integer> list : edges){
            g.addEdge(list.get(0) - 1, list.get(1) - 1);
        }
        
        boolean[] vis = new boolean[n];
        for(int idx = 0; idx < n; idx++){
            if(dfs(idx, g, vis) == true) return true;
        }
        return false;
    }
}
