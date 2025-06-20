https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
Lc 106

class Solution {
    int[] inorder, postorder;

    public int search(int val){
        for(int idx = 0; idx < inorder.length; idx++){
            if(val == inorder[idx]){
                return idx;
            }
        }
        return -1;
    }

    public TreeNode construct(int rootIdx, int low, int high){
        if(low > high) return null;
        if(low == high) return new TreeNode(postorder[rootIdx]);

        TreeNode root = new TreeNode(postorder[rootIdx]);
        int mid = search(postorder[rootIdx]);
        root.left = construct(rootIdx-1 - (high - mid), low, mid - 1);
        root.right = construct(rootIdx-1 , mid + 1, high);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return construct(postorder.length-1, 0, inorder.length-1);
        
    }
}
