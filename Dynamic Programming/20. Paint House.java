// https://www.naukri.com/code360/problems/paint-house_1460385?leftPanelTabValue=PROBLEM

// TC O(n*3)
// SC O(n*3) 
//    - DP O(n*3)
//    - RCS O(n*3) yeh tle dedega kiuki input >= 10^5

// memoization - gives TLE if n is more than 10^5
public class Solution {

    public static int memo(int src, int prev, int[][] cost, int[][] dp) {
        if(src == cost.length) return 0;
        if(prev >= 0 && dp[src][prev] != -1) return dp[src][prev];  // prev kahi -1 toh nahi hai ka check

        int ans0 = (prev != 0) ? memo(src + 1, 0, cost, dp) + cost[src][0] : Integer.MAX_VALUE;  //idhar krre hai add mein 0 wali value thats why check != 0
        int ans1 = (prev != 1) ? memo(src + 1, 1, cost, dp) + cost[src][1] : Integer.MAX_VALUE;
        int ans2 = (prev != 2) ? memo(src + 1, 2, cost, dp) + cost[src][2] : Integer.MAX_VALUE;

        if(prev == -1) return Math.min(ans0, Math.min(ans1, ans2)); // again prev = -1 wala check
        return dp[src][prev] = Math.min(ans0, Math.min(ans1, ans2));
    }

    public static int minCost(int[][] cost) {
        if(cost.length == 0) return 0;

        int[][] dp = new int[cost.length+1][3];

        for(int idx = 0; idx < cost.length + 1; idx++) {
            dp[idx][0] = -1;
            dp[idx][1] = -1;
            dp[idx][2] = -1;
        }

        return memo(0, -1, cost, dp);
    }   
}


// LintCode 515
// https://www.lintcode.com/problem/515/

// tabulation - better than memo as no tle
// TC O(n*3)
// TC O(n*3)
public class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;

        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];    
        dp[0][2] = costs[0][2];    

        for(int idx = 1; idx < costs.length; idx++) {
            dp[idx][0] = costs[idx][0] + Math.min(dp[idx-1][1], dp[idx-1][2]);
            dp[idx][1] = costs[idx][1] + Math.min(dp[idx-1][0], dp[idx-1][2]);
            dp[idx][2] = costs[idx][2] + Math.min(dp[idx-1][0], dp[idx-1][1]);
        }

        return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1], dp[costs.length-1][2]));
    }
}

// tabulation - space optimised
// TC O(n)
// TC O(1)
public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;

        int prev0 = costs[0][0];
        int prev1 = costs[0][1];
        int prev2 = costs[0][2];

        for(int idx = 1; idx < n; idx++) {
            int curr0 = costs[idx][0] + Math.min(prev1, prev2);
            int curr1 = costs[idx][1] + Math.min(prev0, prev2);
            int curr2 = costs[idx][2] + Math.min(prev1, prev0);
            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        return Math.min(prev0, Math.min(prev1, prev2));
    }
}

