class Solution {
    private int memo(int[] nums, int target, int i, int sum, int[][] dp, int S) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + S] != -1) {
            return dp[i][sum + S];
        }

        int plus = memo(nums, target, i + 1, sum + nums[i], dp, S);
        int minus = memo(nums, target, i + 1, sum - nums[i], dp, S);

        return dp[i][sum + S] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int S = 0;
        for (int num : nums) {
            S += num;
        }
        int[][] dp = new int[n][2 * S + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(nums, target, 0, 0, dp, S);
    }
}
