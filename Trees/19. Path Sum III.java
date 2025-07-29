// Lc 437
// https://leetcode.com/problems/path-sum-iii/description/

// TC = O()
// SC = O()

class Solution {
    public int dfs(TreeNode root, long targetSum){
        if(root == null) return 0;

        targetSum -= root.val;
        int path = (targetSum == 0) ? 1 : 0;

        path += dfs(root.left, targetSum);
        path += dfs(root.right, targetSum);
        return path;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
