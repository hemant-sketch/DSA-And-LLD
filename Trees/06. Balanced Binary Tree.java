// Lc 110
// https://leetcode.com/problems/balanced-binary-tree/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public boolean balance = true;
    public int findHeight(TreeNode root){
        if(root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        if(Math.abs(lh - rh) > 1) balance = false;
        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        return balance;
    }
}
