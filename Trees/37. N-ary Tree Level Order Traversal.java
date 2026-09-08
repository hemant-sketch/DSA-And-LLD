// https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
// TC O(n+e)   SC O(n)

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            
            for(int idx = q.size(); idx > 0; idx--){
                Node curr = q.poll();
                level.add(curr.val);

                for(Node node : curr.children){
                    q.add(node);
                }
            }
            levels.add(level);
        }
        return levels;
    }
}
