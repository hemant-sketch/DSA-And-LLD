// Lc - 1316
// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

// TC = O(n+e)
// SC = O(n+e)




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

    public long dfs(int src, boolean[] vis){
        if(vis[src] == true) return 0;
        
        long size = 1l;
        vis[src] = true;
        for(int nbr : adj[src]){
            size += dfs(nbr, vis);
        }
        return size;
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] edge : edges){
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] vis = new boolean[n];
        long answer = 0l;
        for(int idx = 0; idx < n; idx++){
            long size = g.dfs(idx, vis);
            answer += size * (n - size);
        }

        return answer/2l;
    }
}
