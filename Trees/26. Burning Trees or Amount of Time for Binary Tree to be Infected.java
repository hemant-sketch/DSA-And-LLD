// Lc 2385
// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

// TC = O(N)
// SC = O(N)

class Solution {
    int maxTime = 0;

    public void dfs(TreeNode root , int time) {
        if(root == null) return;
        maxTime = Math.max(time, maxTime);

        dfs(root.left, time + 1);
        dfs(root.right, time + 1);
    }

    public int find(TreeNode root, int target){
        if(root == null) return -1;
        if(root.val == target) {
            dfs(root, 0);
            return 1;
        }

        int left = find(root.left, target);
        if(left > 0){
            maxTime = Math.max(left, maxTime);
            dfs(root.right, left + 1);
            return left + 1;
        } 

        int right = find(root.right, target);
        if(right > 0){
            maxTime = Math.max(right, maxTime);
            dfs(root.left, right + 1);
            return right + 1;
        }

        return -1;
    }
    public int amountOfTime(TreeNode root, int target) {  //target is start
        find(root, target);
        return maxTime;
    }
}
