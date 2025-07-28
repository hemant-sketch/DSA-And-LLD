// Lc 104
// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

// TC = O(N)
// SC = O(H) 

class Solution {
    public int maxDepth(TreeNode root) {
        if ( root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
