// Lc 100
// https://leetcode.com/problems/same-tree/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null) return true;  
      if(p == null || q == null) return false;
      if(p.val != q.val) return false;
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
