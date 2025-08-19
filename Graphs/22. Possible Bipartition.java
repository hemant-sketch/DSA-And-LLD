// Lc 886
// https://leetcode.com/problems/possible-bipartition/description/

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

    public class Pair {
        public int src;
        public int color;

        Pair(int src, int color){
            this.src = src;
            this.color = color;
        }
    }

    public boolean bfs(int src, int[] vis){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));

        while(q.size() > 0){
            Pair p = q.remove();
            if(vis[p.src] != -1 && vis[p.src] == p.color) continue;
            if(vis[p.src] != -1 && vis[p.src] != p.color) return false;

            vis[p.src] = p.color;
            for(int nbr : adj[p.src]){
                q.add(new Pair(nbr, 1 - p.color));
            }
        }
        return true;
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] edge : edges){
            g.addEdge(edge[0]-1, edge[1]-1);
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for(int idx = 0; idx < n; idx++){
            if(vis[idx] != -1) continue;
            if(g.bfs(idx, vis) == false){
                return false;
            }
        }
        return true;
    }
}
