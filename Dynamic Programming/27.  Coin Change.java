// Lc 322
// https://leetcode.com/problems/coin-change/description/

// TC O(n)
// SC O(n)

class Solution {
    // int min = 0;
    public long memo(int src, int[] coins, long[] dp) {
        if(src == 0) return 0;
        long min = Integer.MAX_VALUE;
        if(dp[src] != -1) return dp[src];
        
        for(int idx = 0; idx < coins.length; idx++) {
            long ans = src-coins[idx] < 0 ? Integer.MAX_VALUE : memo(src-coins[idx], coins, dp) + 1; 
            min = Math.min(min, ans);
        }

        return dp[src] = min;
    }

    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, -1);
        //Arrays.sort(coins);
        int ans = (int)memo(amount, coins, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
