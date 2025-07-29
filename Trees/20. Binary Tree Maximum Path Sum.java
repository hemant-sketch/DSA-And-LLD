// Lc 124
// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

// TC = O(N)
// SC = O(H)

class Solution {
    long diameter = Long.MIN_VALUE;

    public long height(TreeNode root){
        if(root == null) return 0;

        long lsum = Math.max(height(root.left), 0);   //to ignore negative value (basically agar sum -ve aye toh toh zero lelo uski jagah
        long rsum = Math.max(height(root.right), 0);

        diameter = Math.max(lsum + rsum + root.val, diameter);
        return Math.max(lsum, rsum) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        height(root);
        return (int)diameter;
    }
}
