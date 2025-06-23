// Lc 547
// https://leetcode.com/problems/number-of-provinces/description/

// TC = O(n^2) because adjacency matrix de rakha
// SC = O(n)


class Graph{
    public int n;
    public ArrayList<Integer>[] adj;

    @SuppressWarnings("all")
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

    public void dfs(int src, boolean[] vis){
        if(vis[src] == true) return;

        vis[src] = true;
        for(int nbr : adj[src]){
            dfs(nbr, vis);
        }
    }

}

class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        Graph g = new Graph(n);

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if( row != col && mat[row][col] == 1){
                    g.addEdge(row, col);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int components = 0;
        for(int src = 0; src < n; src++){
            if(vis[src] == true) continue;
            g.dfs(src, vis);
            components++;
        }
        return components;
    }
}
