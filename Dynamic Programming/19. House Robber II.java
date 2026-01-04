// Lc 213
// https://leetcode.com/problems/house-robber-ii/description/

// TC O(n)
// SC O(n)

class Solution {
    public int memo(int idx, int prev, int n, int[] nums, int[][] dp) {
        if(idx > n)  return 0;
        if(dp[idx][prev] != -1) return dp[idx][prev];
        
        int yes = (prev != 1) ? memo(idx + 1, 1, n,  nums, dp) + nums[idx] : 0;
        int no = memo(idx + 1, 0, n, nums, dp);  // idhr nums[idx] nahi kiuki bhai add hi nahi krre yeh 

        return dp[idx][prev] = Math.max(yes, no);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0]; 
        int[][] dp1 = new int[nums.length + 1][2];
        int[][] dp2 = new int[nums.length + 1][2];

        for(int idx = 0; idx < nums.length + 1; idx++) {
            dp1[idx][0] = -1;
            dp1[idx][1] = -1;
            dp2[idx][0] = -1;
            dp2[idx][1] = -1;
        }
        
        return Math.max(memo(0, 0, nums.length - 2, nums, dp1), memo(1, 0, nums.length - 1, nums, dp2));
    }
}



