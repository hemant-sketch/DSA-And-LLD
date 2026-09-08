// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// TC O(n^2) because search hora baar baar, instead use hashmap for O(n)
// SC O(n)

class Solution {
    int preIdx = 0;

    public int search(int[] inorder, int[] preorder, int left, int right) {
        for(int idx = left; idx <= right; idx++) {
            if(preorder[preIdx] == inorder[idx]){
                return idx;
            }
        }
        return -1;
    }

    public TreeNode constructTree(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) return null;

        TreeNode root = new TreeNode(preorder[preIdx]);
        int inIdx = search(inorder, preorder, left, right);
        preIdx++;

        root.left = constructTree(preorder, inorder, left, inIdx-1);
        root.right = constructTree(preorder, inorder, inIdx+1, right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, inorder, 0, preorder.length-1);
    }
}
