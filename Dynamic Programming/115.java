class Solution {
    public int memo(int i, int j, String s, String t, int[][] dp) {
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = memo(i + 1, j + 1, s, t, dp)  + memo(i + 1, j, s, t, dp);
        }else {
            dp[i][j] = memo(i + 1, j, s, t, dp);
        }

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return memo(0, 0, s, t, dp);
    }
}
