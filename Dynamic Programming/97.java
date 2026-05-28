class Solution {
    int m;
    int n;
    int N;

    public boolean memo(int i, int j, String s1, String s2, String s3, int[][] dp) {
        if (i == m && j == n && i + j == N)
            return true;

        if (i + j >= N)
            return false;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean result = false;

        if (i < m && s1.charAt(i) == s3.charAt(i + j)) {
            result = memo(i + 1, j, s1, s2, s3, dp);
        }

        if (result)
        {
            dp[i][j] = 1;
            return true;
        }

        if (j < n && s2.charAt(j) == s3.charAt(i + j)) {
            result = memo(i, j + 1, s1, s2, s3, dp);
        }

        dp[i][j] = result ? 1 : 0;
        return dp[i][j] == 1;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(0, 0, s1, s2, s3, dp);
    }
}
