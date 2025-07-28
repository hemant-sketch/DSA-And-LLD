// Lc 543
// https://leetcode.com/problems/diameter-of-binary-tree/description/

// TC = O(N)
// SC = O(H)

class Solution {
    public int maxDepth(TreeNode root, int[] arr){
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left, arr);
        int rightHeight = maxDepth(root.right, arr);
        arr[0] = Math.max(arr[0], leftHeight + rightHeight  + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] arr = {0};
        maxDepth(root, arr);
        return arr[0] - 1;
    }
}
