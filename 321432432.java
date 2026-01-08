class Solution {
    int[][] dp;

    public int memo(int idx1, int idx2, int[] nums1, int[] nums2) {
        if (idx1 == nums1.length || idx2 == nums2.length)
            return Integer.MIN_VALUE;

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        int takeBoth = nums1[idx1] * nums2[idx2]
                     + Math.max(0, memo(idx1 + 1, idx2 + 1, nums1, nums2));

        int skip1 = memo(idx1 + 1, idx2, nums1, nums2);
        int skip2 = memo(idx1, idx2 + 1, nums1, nums2);

        return dp[idx1][idx2] = Math.max(takeBoth, Math.max(skip1, skip2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][nums2.length];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return memo(0, 0, nums1, nums2);
    }
}
