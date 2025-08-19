// https://www.geeksforgeeks.org/problems/alien-dictionary/1

// TC = O(N+E)
// SC = O(N+E)

@SuppressWarnings("all")
class Graph {
    public int n;
    public ArrayList<Character>[] adj;
    
    public Graph (int n){
        this.n = n;
        adj = new ArrayList[n];
        for(int idx = 0; idx < n; idx++){
            adj[idx] = new ArrayList<>();
        }
    }
    
    public void addEdge(char src, char dest){
        adj[src - 'a'].add(dest);
    }
}


class Solution {
    
    public String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        // Mark present characters
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }
        
        int n = words.length;
        Graph g = new Graph(26);
        
        // Build graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    g.addEdge(c1, c2);
                    found = true;
                    break;
                }
            }
            // Check for invalid prefix: word1 longer than word2 and word2 is prefix
            if (!found && word1.length() > word2.length()) {
                return "";
            }
        }
        
        int[] visited = new int[26]; // 0: unvisited, 1: visiting, 2: visited
        StringBuilder topo = new StringBuilder();
        
        // Perform DFS for each unvisited present node
        for (int i = 0; i < 26; i++) {
            if (present[i] && visited[i] == 0) {
                if (!dfs(g, i, visited, present, topo)) {
                    return "";
                }
            }
        }
        
        return topo.reverse().toString();
    }
    
    private boolean dfs(Graph g, int node, int[] visited, boolean[] present, StringBuilder topo) {
        if (visited[node] == 1) { // Cycle detected
            return false;
        }
        if (visited[node] == 2) { // Already visited
            return true;
        }
        visited[node] = 1; // Mark as visiting
        for (char nbrChar : g.adj[node]) {
            int nbr = nbrChar - 'a';
            if (visited[nbr] == 0) {
                if (!dfs(g, nbr, visited, present, topo)) {
                    return false;
                }
            } else if (visited[nbr] == 1) { // Cycle detected
                return false;
            }
        }
        visited[node] = 2; // Mark as visited
        topo.append((char)(node + 'a')); // Append after visiting neighbors
        return true;
    }
}
