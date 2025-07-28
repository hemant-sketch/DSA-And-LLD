// Lc 110
// https://leetcode.com/problems/balanced-binary-tree/description/

// TC = O(N)
// SC = O(H)

// this is okay but not the best solution, because global variable
class Solution {
    public boolean balance = true;
    public int findHeight(TreeNode root){
        if(root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        if(Math.abs(lh - rh) > 1) balance = false;
        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        return balance;
    }
}

// the most optimised solution
class Solution {
    public static class Pair{
        int height = 0;
        boolean balance = true;
    }

    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        Pair curr = new Pair();
        curr.height = Math.max(l.height, r.height) + 1;
        curr.balance = l.balance && r.balance;     //kiuki curr.balance humesha true rahega agar yeh check nhi diya toh
        if(Math.abs(l.height - r.height) > 1) curr.balance = false;
        return curr;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balance;
    }
}
