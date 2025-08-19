// https://www.naukri.com/code360/problems/parallel-courses_1376444?leftPanelTabValue=PROBLEM

// TC = O(N+E)
// SC = O(N+E)

import java.util.*;

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
public class Solution {
    static class Pair {
        public int courseID;
        public int semester;

        public Pair(int courseID, int semester){
            this.courseID = courseID;
            this.semester = semester;
        }
    }

    public static int parallelCourses(int n, int[][] pre) {
        // Write your code here
        Graph g = new Graph(n);
        for(int[] edge : pre){
            g.addEdge(edge[1]-1, edge[0]-1);
        }

        int[] incoming = new int[n];
        for(int[] edge : pre){
            incoming[edge[0]-1]++;
        }

        Queue<Pair> q = new ArrayDeque<>();
        for(int idx = 0; idx < n; idx++){
            if(incoming[idx] == 0){
                q.add(new Pair(idx, 1));
            }
        }

        int ans = 0;
        while(q.size() > 0){
            Pair p = q.remove();
            ans = Math.max(ans, p.semester);

            for(int nbr : g.adj[p.courseID]){
                incoming[nbr]--;
                if(incoming[nbr] == 0){
                    q.add(new Pair(nbr, p.semester + 1));
                }
            }
        }

        for(int idx = 0; idx < n; idx++){
            if(incoming[idx] > 0) return -1;
        }
        
        return ans;

        
    }
}
