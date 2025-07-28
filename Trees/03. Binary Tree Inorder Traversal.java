// Lc 94
// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

// TC = O(N)
// TC = O(N)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    public void inorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
