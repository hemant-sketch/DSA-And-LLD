// Lc 1379
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/

// TC = O(N)
// TC = O(H)

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || cloned == null) return null;
        if(original == target) return cloned;

        TreeNode l  = getTargetCopy(original.left, cloned.left, target);
        if( l != null) return l;

        return getTargetCopy(original.right, cloned.right, target);
    }
}
