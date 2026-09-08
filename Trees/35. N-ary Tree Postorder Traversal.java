// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
// TC O(n+e) SC O(n)

class Solution {
    List<Integer> ans = new ArrayList<>();

    public void dfs(Node root){
        for(Node node : root.children){
            dfs(node);
        }
        ans.add(root.val);
    }  
    public List<Integer> postorder(Node root) {
        if(root == null) return ans;
        dfs(root);
        return ans;
    }
}
