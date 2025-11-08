// Lc 70
// https://leetcode.com/problems/climbing-stairs/

// Tc = O(2^N)
// SC = O(1)

// recursion  TLE
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        int way1 = climbStairs(n-1);
        int way2 = climbStairs(n-2);
        //int way3 = climbStairs(n-3);

        return way1 + way2;
    }
}

// better recursion  TLE
class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;

        //if(n < 0) return 0;

        int way1 = n-1 >= 0 ? climbStairs(n-1) : 0;
        int way2 = n-2 >= 0 ? climbStairs(n-2) : 0;
        //int way3 = climbStairs(n-3);

        return way1 + way2;
    }
}


// memoization

// Tc = O(N)
// SC = O(N)
class Solution {
    public int helper(int dp[], int n) {
        if(n == 0) return 1;
        //if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        int way1 = n-1 >= 0 ? helper(dp, n-1) : 0;
        int way2 = n-2 >= 0 ? helper(dp, n-2) : 0;
        //int way3 = climbStairs(n-3);

        dp[n] = way1 + way2;
        return way1 + way2;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(dp, n);
    }
}


// tabulation

// Tc = O(N)
// SC = O(N)

class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int idx = 1; idx <= n; idx++) {
            int way1 = idx-1 >= 0 ? dp[idx-1] : 0; 
            int way2 = idx-2 >= 0 ? dp[idx-2] : 0; 
            dp[idx] = way1 + way2;
        }

        return dp[n];
    }
}


// tabulation optimised

// Tc = O(N)
// SC = O(1)
class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        int prev1 = 1;
        int prev2 = 0;

        for(int idx = 0; idx <= n; idx++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}


