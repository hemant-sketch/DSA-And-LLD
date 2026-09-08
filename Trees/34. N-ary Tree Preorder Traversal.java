// https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
// TC O(n+e) SC O(n)

class Solution {
    public void dfs(Node root, List<Integer> ans) {
        // if(root == null) return;   //kiuki tu call hi legit maar raha hai, koi null wala case aega hi nahi
        ans.add(root.val);

        for (Node nodes : root.children) {
            dfs(nodes, ans);
        }
    }

    public List<Integer> preorder(Node root) { 
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        dfs(root, ans);

        return ans;
    }
}
