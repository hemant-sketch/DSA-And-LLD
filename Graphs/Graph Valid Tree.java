class Solution {
    int count;

    public void dfs(List<List<Integer>> adj, boolean[] vis, int src) {
        vis[src] = true;

        for(int nbr : adj.get(src)) {
            if(vis[nbr] == false) {
                count++;
                dfs(adj, vis, nbr);
            }
        }
    }

    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if(m != n-1) return false;

        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>(n);
        for(int idx = 0; idx < n; idx++) {
            adj.add(new ArrayList<>());
        }

        for(int idx = 0; idx < m; idx++) {
            adj.get(edges[idx][0]).add(edges[idx][1]);
            adj.get(edges[idx][1]).add(edges[idx][0]);
        }

        count = 1;
        dfs(adj, vis, 0);
        return count == n;
    }
}
