// Lc 84
// https://leetcode.com/problems/largest-rectangle-in-histogram/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int[] rightNSE(int[] nums){
        int n = nums.length;   
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];

        for(int idx = n-1; idx >= 0; idx--){
            while(stk.size() > 0 && nums[stk.peek()] >= nums[idx]){
                stk.pop();
            }
            res[idx] = (stk.size() > 0) ? stk.peek() : n;
            stk.push(idx);
        }
        return res;
    }

    public int[] leftNSE(int[] nums){
        int n = nums.length;   
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];

        for(int idx = 0; idx < n; idx++){
            while(stk.size() > 0 && nums[stk.peek()] >= nums[idx]){
                stk.pop();
            }
            res[idx] = (stk.size() > 0) ? stk.peek() : -1;
            stk.push(idx);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] left = leftNSE(heights);
        int[] right = rightNSE(heights);
        int max = 0;

        for(int idx = 0; idx < heights.length; idx++){
            int area = heights[idx] * (right[idx] - left[idx] -1);
            max = Math.max(max, area);
        }
        return max;
    }
}
