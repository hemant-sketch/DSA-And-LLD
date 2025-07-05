// Lc 167
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

// TC = O(N)
// SC = O(1)

//Two Sum wala bhai krdena hashing se
// count pairs with given sum(gfg), can be done by hashmap only - yeh bhi kahi krwwaya hai
// 9 wala is best with hashmap  3.18 of first video of this
// https://www.interviewbit.com/problems/maximum-sum-triplet/      yeh bhi nhi hua hai abhi

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
