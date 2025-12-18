// https://www.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-conditio

// TC O(N)
// SC O(N)

class Solution {
    public int memo(int src, int[] dp) {
        if(src == 1) return 0;
        if(dp[src] != -1) return dp[src];
        
        int ans1 = src % 2 == 0 ? memo(src/2, dp) : Integer.MAX_VALUE;
        int ans2 = src % 3 == 0 ? memo(src/3, dp) : Integer.MAX_VALUE;
        int ans3 = memo(src - 1, dp);
        
        return dp[src] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }

    public int minSteps(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return memo(N, dp);
    }
}
