// Lc 128
// https://leetcode.com/problems/longest-consecutive-sequence/description/

// Two Pointer
// TC = O(N*logN)
// SC = O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int left = 0, max = 0;

        while(left < nums.length){
            int right = left + 1;

            int count = 1;
            while(right < nums.length && nums[right] <= nums[right-1] + 1){
                if(nums[right] == nums[right-1]+1){
                    count++;
                }
                right++;
            }

            max = Math.max(max, count);
            left = right;
        }
        return max;
    }
}

// Hashmap
//
//
