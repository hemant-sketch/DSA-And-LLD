// https://www.geeksforgeeks.org/problems/topological-sort/1

//TC = O(N+E)
//SC = O(N+E)

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
    }
    
    public void dfs(int src, boolean[] vis, Stack<Integer> stk){
        if(vis[src] == true) return;
        vis[src] =  true;
        
        for(int nbr : adj[src]){
            dfs(nbr, vis, stk);
        }
        
        stk.push(src);
    }
}

class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Graph g = new Graph(V);
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }
        
        Stack<Integer> stk = new Stack<>();
        boolean[] vis = new boolean[V];
        
        for(int idx = 0; idx < V; idx++){
            g.dfs(idx, vis, stk);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int idx = 0; idx < V; idx++){
            ans.add(stk.pop());
            
        }
        return ans;
        
    }
}
