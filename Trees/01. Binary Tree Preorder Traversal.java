// Lc 144
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> ans = new ArrayList <>();
        preorder (root, ans);
        return ans;
    }
    public void preorder (TreeNode root, List <Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
