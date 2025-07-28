// Lc 1367
// https://leetcode.com/problems/linked-list-in-binary-tree/description/

// TC = O(N^2)
// SC = O(H)

class Solution {
    public boolean dfs(ListNode head, TreeNode root){
        if(head == null) return true;
        if(root == null) return  false;
        if(root.val != head.val) return false;

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return  false;
        
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
