// Lc 337
// https://leetcode.com/problems/house-robber-iii/description/

// TC = O(N)
// SC = O(H)

// 50 30 70 10 100 5 3 n n 40 20 n 80 7 n
class Solution {
    public class Pair{ int yes, no; }

    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        Pair curr = new Pair();
        curr.no = l.yes + r.yes;
        curr.yes = Math.max(curr.no, root.val + l.no + r.no);
        return curr;
    }
    public int rob(TreeNode root) {
        return dfs(root).yes;
    }
}
