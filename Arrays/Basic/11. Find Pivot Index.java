// Lc 724
// https://leetcode.com/problems/find-pivot-index/description/

// TC = O(n)
// SC = O(2n)

class Solution {
    public int[] getPrefix(int[] nums) {
        int[] prefix = new int[nums.length];

        for (int idx = 0; idx < nums.length; idx++) {
            prefix[idx] = nums[idx] + ((idx > 0) ? prefix[idx - 1] : 0);
        }
        return prefix;
    }

    public int[] getSuffix(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {
            suffix[idx] = nums[idx] + ((idx < n - 1) ? suffix[idx + 1] : 1);
        }
        return suffix;
    }

    public int pivotIndex(int[] nums) {
        int[] prefix = getPrefix(nums);
        int[] suffix = getSuffix(nums);

        for (int idx = 0; idx < nums.length; idx++) {
            if (prefix[idx] == suffix[idx]) {
                return idx;
            }
        }
        return -1;

    }
}
