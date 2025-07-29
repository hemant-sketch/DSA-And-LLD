// Lc 113
// https://leetcode.com/problems/path-sum-ii/description/

// TC = O(N)
// TC = O(H)

class Solution {
    List<List<Integer>> paths;
    public void dfs(TreeNode root, int targetSum, List<Integer> path){
        if(root == null) return;
        targetSum -= root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            paths.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }
}
