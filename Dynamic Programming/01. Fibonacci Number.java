// Lc 509
// https://leetcode.com/problems/fibonacci-number/description/

// Memoization
// TC = O(N)  //base case ki call ko nahi mante kuch hoti woh
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

// Tabulation
// TC = O(N)  
// SC = O(N)
class Solution {
    public int fib(int n){
        if(n == 0 || n == 1) return n;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int idx = 2; idx <= n; idx++){
            dp[idx] = dp[idx-1] + dp[idx-2];
        }

        return dp[n];
    }
}

// Space Optimization   // Two pointer technique
// TC = O(N)  
// SC = O(1)
class Solution {
    public int fib(int n){
        if(n == 0 || n == 1) return n;
        
        int prev1 = 0;
        int prev2 = 1;

        for(int idx = 2; idx <= n; idx++){
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;

        }

        return prev2;
    }
}

// Binet's formula
