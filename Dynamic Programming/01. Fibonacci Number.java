// Lc 509
// https://leetcode.com/problems/fibonacci-number/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int helper(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != -1) return dp[n];

        int prev1 = helper(n-1, dp);
        int prev2 = helper(n-2, dp);

        dp[n] = prev1 + prev2;
        return prev1 + prev2;
    }
    public int fib(int n) {
        int[] dp = new int[n+1]; //taaki zero on zero index rahe
        Arrays.fill(dp, -1);
        return helper(n , dp);
    }
}
