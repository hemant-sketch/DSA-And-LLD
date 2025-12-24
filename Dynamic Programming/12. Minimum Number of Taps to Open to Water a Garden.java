// Lc 1326
// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/

// TC O(N^2)
// OC O(N)

class Solution {
    public int memo(int src, int[] reach, int[] dp) {
        if (src >= reach.length-1) return 0;
        if(dp[src] != -1) return dp[src];

        int min = Integer.MAX_VALUE;
        for(int jump = 1; jump <= reach[src]; jump++){
            if((jump + src) < reach.length) {
                min = Math.min(min, memo(src + jump, reach, dp));
            }
        }
        if(min != Integer.MAX_VALUE) return dp[src] = min + 1;
        else return dp[src] = min;
    }

    public int minTaps(int n, int[] ranges) {
        // int n = ranges.length nahi hai question padh dhangse
        int[] maxReach = new int[n+1];

        for(int idx = 0; idx <= n; idx++) {
            int left = Math.max(0, idx - ranges[idx]);
            int right = Math.min(n, idx + ranges[idx]);

            maxReach[left] = Math.max(right - left, maxReach[left]);  //yeh ki agar ek point se do taps start hore ho;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = memo(0, maxReach, dp);
        if(ans == Integer.MAX_VALUE) return -1;
        else return ans;
    }
}
