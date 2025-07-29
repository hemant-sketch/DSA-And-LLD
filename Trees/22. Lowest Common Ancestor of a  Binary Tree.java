// Lc 236
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode  lans = lowestCommonAncestor(root.left, p, q);
        TreeNode  rans = lowestCommonAncestor(root.right, p, q);

        if(lans != null && rans != null) return root;
        return (lans != null) ? lans : rans;
    }
}
