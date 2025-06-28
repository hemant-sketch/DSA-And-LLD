// https://www.naukri.com/code360/problems/shortest-path-in-an-unweighted-graph_981297?leftPanelTabValue=PROBLEM

//
//

import java.util.*;

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

	public static class Pair{
		int src, dist, par;
		Pair(int src, int dist, int par){
			this.src = src;
			this.dist = dist;
			this.par = par;
		}
	}
	public LinkedList<Integer> bfs(int src, int dest){
		int[] par = new int[n];	
		int[] dist = new int[n];	
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, 0, -1));

		while(q.size() > 0){
			Pair p = q.remove();
			if(dist[p.src] < Integer.MAX_VALUE) continue;
			dist[p.src] = p.dist; 
			par[p.src] = p.par;
			if(p.src == dest) break;

			for(Integer nbr : adj[p.src]){
				q.add(new Pair(nbr, p.dist + 1, p.src ));
			}

		}

		LinkedList<Integer> path = new LinkedList<>();
		int curr =  dest;
		while(curr != -1){
			path.addFirst(curr);
			curr = par[curr];
		}
		return path;
	}
}

public class Solution {

	public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
		// Write your code here.
		Graph g = new Graph(n + 1);
		for(int[] edge : edges){
			g.addEdge(edge[0], edge[1]);
		}
		
		return g.bfs(s, t);

	}

}
