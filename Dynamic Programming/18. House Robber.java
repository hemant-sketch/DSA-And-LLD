
// 10 , 20, 60, 40, 30, 100

class Solution {
    public int memo(int idx, int prev, int[] nums, int[][] dp) {
        if(idx == nums.length)  return 0;
        if(dp[idx][prev] != -1) return dp[idx][prev];
        
        int yes = (prev != 1) ? memo(idx + 1, 1, nums, dp) + nums[idx] : 0;
        int no = memo(idx + 1, 0, nums, dp);  // idhr nums[idx] nahi kiuki bhai add hi nahi krre yeh 

        return dp[idx][prev] = Math.max(yes, no);
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];

        for(int idx = 0; idx < nums.length + 1; idx++) {
            dp[idx][0] = -1;
            dp[idx][1] = -1;
        }
        
        return memo(0, 0, nums, dp);
    }
}
