// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

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
        adj[dest].add(src);
    }
    
    class Pair {
        public int src;
        public int par;
        public Pair(int src, int par){
            this.src = src;
            this.par = par;
        }
    }
    
    
    public boolean bfs(int src, boolean[] vis){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, -1));
        
        while(q.size() > 0){
            Pair p = q.remove();
            if(vis[p.src] == true) return true;
            vis[p.src] = true;
            
            for(int nbr : adj[p.src]){
                if(nbr == p.par) continue;
                q.add(new Pair(nbr, p.src));
            }
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
            if(vis[idx] == false && g.bfs(idx, vis) == true){
                    return true;
            } 
        }
        return false;
    }
}
