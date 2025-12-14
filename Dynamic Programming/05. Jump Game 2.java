// Lc 45
// https://leetcode.com/problems/jump-game-ii/description/

// TC = O(N*jumps)
// SC = O(N)

class Solution {
    public int jump(int[] jumps) {
        long[] dp = new long[jumps.length];
        Arrays.fill(dp, -1);

        return (int)memo(0, jumps, dp);
    }

    public long memo(int src, int[] jumps, long[] dp) {
        if(src == jumps.length -1) return 0;
        if(dp[src] != -1) return dp[src];
        long min = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[src]; jump++) {
            if(src + jump < jumps.length) {
                min = Math.min(min, memo(src + jump, jumps, dp) + 1);
            }
        } 
        dp[src] = min;
        return min;
    }
}
