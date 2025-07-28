// Lc 563
// https://leetcode.com/problems/binary-tree-tilt/description/

// TC = O(N)
// SC = O(H)

class Solution {
    int sum = 0;
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int lsum = dfs(root.left);
        int rsum = dfs(root.right);
        sum += Math.abs(lsum - rsum);

        return lsum + rsum + root.val; 
    }
    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }
}
