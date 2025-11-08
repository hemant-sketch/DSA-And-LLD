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


