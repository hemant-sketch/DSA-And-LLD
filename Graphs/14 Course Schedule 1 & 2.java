// Lc 207
// https://leetcode.com/problems/course-schedule/description/

// TC =  O(N+E)
// SC =  O(N+E)

class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph (int n){
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
    public boolean canFinish(int n, int[][] pre) {
        Graph g = new Graph(n);
        for(int[] edge : pre){
            g.addEdge(edge[1], edge[0]);
        }

        int[] incoming = new int[n];
        for(int[] edge : pre){
            incoming[edge[0]]++;
        }

        int[] topo = new int[n];
        int pop = 0, push = 0;

        for(int idx = 0; idx < n; idx++){
            if(incoming[idx] == 0){
                topo[push++] = idx;
            }
        }

        while(pop < push && push < n){
            int src = topo[pop++];

            for(int nbr : g.adj[src]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    topo[push++] = nbr;
                }
            }
        }
        if(push == n) return true;
        else return false;
    }
}






// Lc 210
// https://leetcode.com/problems/course-schedule-ii/description/

// TC =  O(N+E)
// SC =  O(N+E)

class Graph {
    public int n;
    public ArrayList<Integer>[] adj;

    public Graph (int n){
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
    public int[] findOrder(int n, int[][] pre) {
        Graph g =new Graph(n);
        for(int[] edge : pre){
            g.addEdge(edge[1], edge[0]);
        }

        int[] incoming = new int[n];
        for(int[] edge : pre){
            incoming[edge[0]]++;
        }

        int[] topo = new int[n];
        int pop = 0, push = 0;

        for(int idx = 0; idx < n; idx++){
            if(incoming[idx] == 0){
                topo[push++] = idx;
            }
        }

        while(pop < push && push < n){
            int src = topo[pop++];

            for(int nbr : g.adj[src]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    topo[push++] = nbr;
                }
            }
        }
        if(push == n) return topo;
        else return new int[0];

        
    }
}
