// Lc 1971
// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

// TC = O(exponential) 
// Sc = O(n)

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

    public boolean hasPath(int src, int dest, boolean[] vis){
        if(src == dest) return true;
        if(vis[src] == true) return false;

        vis[src] = true;
        for(int nbr : adj[src]){
            if(hasPath(nbr, dest, vis) == true){
                return true;
            }
        }
        return false;

    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] vis = new boolean[n];
        return g.hasPath(source, destination, vis);
    }
}
