// Lc - 
// https://leetcode.com/problems/all-paths-from-source-to-target/description/

TC = 
SC = 

class Solution {
    List<List<Integer>> paths = new ArrayList<>();

    public void dfs(int src, int dest, List<Integer> path, int[][] graph){
        path.add(src);

        if(src == dest){
            paths.add(new ArrayList<>(path));
        }

        for(int nbr : graph[src]){
            dfs(nbr, dest, path, graph);
        }

        path.remove(path.size() - 1);


    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        dfs(0, n-1, new ArrayList<>(), graph);
        return paths;
    }
}
