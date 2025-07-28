// Lc 145
// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    public void postorder(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
