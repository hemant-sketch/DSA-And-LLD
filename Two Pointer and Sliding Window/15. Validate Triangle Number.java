// Lc 611
// https://leetcode.com/problems/valid-triangle-number/description/

// TC = O(N^2)
// SC = O(logN)

class Solution {
    public int twoSumGreater(int[] nums, int right, int target){
        int left = 0;
        int count = 0;

        while(left < right){
            int sum = nums[left] + nums[right];

            if(sum <= target){
                left++;
            }else{
                count += right - left;
                right--;
            }
        }
        return count;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int last = nums.length-1; last > 1; last--){
            count += twoSumGreater(nums, last-1, nums[last]);
        }
        return count;
    }
}
