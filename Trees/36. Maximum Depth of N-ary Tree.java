// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
// TC O(n+e)  SC O(n)

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;

        int height  = 0;
        for(Node node : root.children){
            height = Math.max(height, maxDepth(node));
        }

        return height + 1;
    }
}
