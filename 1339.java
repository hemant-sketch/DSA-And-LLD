class Solution {
    int totalSum = 0;
    Long max = Long.MIN_VALUE;
    public int helper(TreeNode root) {
        if(root == null) return 0;

        long leftSum = helper(root.left);
        long rightSum = helper(root.right);

        max = Math.max(max, leftSum*(totalSum-leftSum));
        max = Math.max(max, rightSum*(totalSum-rightSum));

        return (int)(root.val + leftSum + rightSum);
    }
    public int getSum(TreeNode root) {
        if(root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);        
    }
    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        helper(root);
        return (int)(max%1000000007);
    }
}
