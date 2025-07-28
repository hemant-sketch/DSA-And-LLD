// Lc 101
// https://leetcode.com/problems/symmetric-tree/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null) return true;  
      if(p == null || q == null) return false;
      if(p.val != q.val) return false;
      return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return isSameTree(root.left, root.right);
    }
}
