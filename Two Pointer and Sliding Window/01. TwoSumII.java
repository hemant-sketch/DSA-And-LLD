// Lc 167
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

// TC = O(N)
// SC = O(1)

//Two Sum wala bhai krdena hashing se

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] ans = new int[2]; 

        while(left < right){
            if(nums[left] + nums[right] == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }

            if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
