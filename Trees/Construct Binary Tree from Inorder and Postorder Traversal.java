https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
Lc 106

    //Shraddha
    class Solution {
    int postIdx;

    public int search(int[] inorder, int[] postorder, int left, int right) {
        for(int idx = left; idx <= right; idx++) {
            if(postorder[postIdx] == inorder[idx]) return idx;
        }
        return -1;
    }

    public TreeNode constructBinaryTree(int[] inorder, int[] postorder, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(postorder[postIdx]);
        int inIdx = search(inorder, postorder, 0, inorder.length-1);
        postIdx--;

        root.right = constructBinaryTree(inorder, postorder, inIdx+1, right);
        root.left = constructBinaryTree(inorder, postorder, left, inIdx-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        return constructBinaryTree(inorder, postorder, 0, inorder.length-1);
    }
}


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
