class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            boolean[] visited = new boolean[n + 1];
            
            if (dfs(graph, u, v, visited)) {
                return edge;
            }
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        return new int[0];
    }
    private boolean dfs(ArrayList<Integer>[] graph, int src, int target, boolean[] visited) {
        if (src == target) return true;
        
        visited[src] = true;
        
        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, target, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}


