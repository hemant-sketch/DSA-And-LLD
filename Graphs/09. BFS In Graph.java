// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

// TC = O(N + E)
// Sc = 0(N + E)
// Queue space = O(E)

// marking visited after removing from the queue
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        
        while(q.size() > 0){
            int src = q.remove();
            if(vis[src] == true) continue;
            
            vis[src] = true;
            ans.add(src);
            
            for(int nbr : adj.get(src)){
                q.add(nbr);
            }
        }
        
        return ans;
    }
}

//marking visited before add to the queue
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        
        while(q.size() > 0){
            int src = q.remove();
            ans.add(src);
            
            for(int nbr : adj.get(src)){
                if(vis[nbr] == false){
                    q.add(nbr);
                    vis[nbr] = true;
                }    
            }
        }
        
        return ans;
    }
}
