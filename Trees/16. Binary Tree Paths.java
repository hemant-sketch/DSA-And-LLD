// Lc 257
// https://leetcode.com/problems/binary-tree-paths/description/

// TC = O(N);
// SC = O(H);


class Solution {
    List<String> paths = new ArrayList<>();

    public void dfs(TreeNode root, String path){
        if(root == null) return;
        path += root.val;
        if(root.left == null && root.right == null){
            paths.add(path);
            return;
        }

        dfs(root.left, path + "->");
        dfs(root.right, path + "->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return paths;
    }
}
