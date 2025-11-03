// Lc 1480
// https://leetcode.com/problems/running-sum-of-1d-array/description/

// Tc = O(n)
// Sc = O(1)


class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        
        for(int idx = 1; idx < nums.length; idx++) {
            ans[idx] = nums[idx] + ans[idx-1];
        }

        return ans;
    }
}
