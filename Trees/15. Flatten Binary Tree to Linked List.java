// Lc 114
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public class Pair{
        TreeNode head, tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(null, null);
        }
        if(root.left == null && root.right == null){
            return new Pair(root, root);
        }

        if(root.left == null){
            Pair r = dfs(root.right);
            return new Pair(root, r.tail);
        }

        if(root.right == null){
            Pair l = dfs(root.left);
            root.left = null;
            root.right = l.head;
            return new Pair(root, l.tail);
        }

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        root.left = null;
        root.right = l.head;
        l.tail.right = r.head;

        return new Pair(root, r.tail);
    }
    public void flatten(TreeNode root) {
        dfs(root);
    }
}
