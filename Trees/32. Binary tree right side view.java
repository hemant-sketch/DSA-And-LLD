// https://leetcode.com/problems/binary-tree-right-side-view/

//

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        if(root == null) return right;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while(!q.isEmpty()){
            right.add(q.peek().val);
            int size = q.size();

            for(int idx = 0; idx < size; idx++) {
                TreeNode src = q.poll();
                if(src.right != null) q.add(src.right);
                if(src.left != null) q.add(src.left);
            }
        }

        return right;

    }
}
