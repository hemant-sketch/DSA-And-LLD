// Lc 968
// https://leetcode.com/problems/binary-tree-cameras/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public static enum State {
        COVERED, NEED, CAMERA;
    }
    int camera = 0;

    public State dfs(TreeNode root){
        if(root == null) return State.COVERED;

        State ls = dfs(root.left);
        State rs = dfs(root.right);
        
        if(ls == State.NEED || rs == State.NEED){
            camera++;
            return State.CAMERA;
        }

        if(ls == State.COVERED && rs == State.COVERED){
            return State.NEED;
        }

        return State.COVERED;
    }

    public int minCameraCover(TreeNode root) {
        if(dfs(root) == State.NEED){
            camera++;
        }
        return camera;
    }
}
