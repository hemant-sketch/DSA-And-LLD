https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
Lc 105


class Solution {
    int[] preorder, inorder;

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
        if(low == high) return new TreeNode(preorder[rootIdx]);

        TreeNode root = new TreeNode(preorder[rootIdx]);
        int mid = search(preorder[rootIdx]);
        root.left = construct(rootIdx + 1, low, mid - 1);
        root.right = construct(rootIdx + 1 + (mid - low), mid + 1, high);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return construct(0, 0, inorder.length-1);
    }
}
