// Lc 863
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

// TC = O(N)
// SC = O(N)

class Solution {
    List<Integer> ans = new ArrayList<>();

    public int find(TreeNode root, TreeNode target, int k) {
        if(root == null) return -1;
        if(root == target) {
            dfs(root, k);
            return 1;
        }

        int left = find(root.left, target, k);
        if(left > 0){
            dfs(root.right, k - left - 1);
            if(left == k) ans.add(root.val);
            return 1 + left;
        }

        int right = find(root.right, target, k);
        if(right > 0){
            dfs(root.left, k - right - 1);
            if(right == k) ans.add(root.val);
            return 1 + right;
        }
        return -1;
    }

    public void dfs(TreeNode root, int k) { 
        if(k < 0 || root == null) return;
        if(k == 0) ans.add(root.val);
        dfs(root.left, k-1);
        dfs(root.right, k-1);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root, target, k);
        return ans;    
    }
}
