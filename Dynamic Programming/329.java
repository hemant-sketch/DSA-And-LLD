class Solution {
    int n; 
    int m;

    public boolean isSafe(int row, int col) {
        if(row >= 0 && col >= 0 && row < n && col < m) {
            return true;
        }
        return false;
    }

    public int[][] directions = {{-1,0}, {1,0}, {0,1}, {0, -1}};

    public int memo(int row, int col, int[][] grid, int[][] dp) {
        int length = 1; //kiuki ques mein mentioned hai ki ek cell khudme bhi ek ans hai

        if(dp[row][col] != -1) return dp[row][col];

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(isSafe(newRow, newCol) && grid[newRow][newCol] < grid[row][col]) {
                length = Math.max(length, memo(newRow, newCol, grid, dp) + 1);
            }
        }

        return dp[row][col] = length;
    }

    public int longestIncreasingPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] dp = new int[n+1][m+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int maxLength = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                maxLength = Math.max(memo(row, col, grid, dp), maxLength);
            }
        }

        return maxLength;
    }
}
