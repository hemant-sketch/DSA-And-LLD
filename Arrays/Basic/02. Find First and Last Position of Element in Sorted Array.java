// Lc 34
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// TC = O(n)
// SC = O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccur = -1;
        int lastOccur = -1;

        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] == target) {
                if(firstOccur == -1) {
                    firstOccur = idx;
                }
                lastOccur = idx;
            }
        }

        int[] ans = {firstOccur, lastOccur};
        return ans; 
    }
}
