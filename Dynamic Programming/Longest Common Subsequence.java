class Solution {
    int m;
    int n;

    public int memo(String s1, String s2, int i, int j, int[][] dp) {
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + memo(s1, s2, i+1, j+1 , dp);
        }

        int ans1 = memo(s1, s2, i+1, j, dp);
        int ans2 = memo(s1, s2, i, j+1, dp);

        return dp[i][j] =  Math.max(ans1, ans2);
    }
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(s1, s2, 0, 0, dp);
    }
}
