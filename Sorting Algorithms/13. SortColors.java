// Lc 75
// https://leetcode.com/problems/sort-colors/description/

// 2 pass method
// TC = O(2N)
// SC = O(1)

class Solution {
    public void sortColors(int[] nums) {
        int zeroes = 0, ones = 0, twos = 0;

        for(int val : nums){
            if(val == 0) zeroes++;
            else if(val == 1) ones++;
            else twos++;
        }

        for(int idx = 0; idx < nums.length; idx++){
            if(idx < zeroes) nums[idx] = 0;
            else if(idx < zeroes + ones) nums[idx] = 1;
            else nums[idx] = 2;
        }
    }
}

// Partioning Method (single pass)
// TC = O(N)
// SC = O(1)
// not stable

class Solution {
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = nums.length - 1;
        while(ones <= twos){
            if(nums[ones] == 0){
                swap(nums, zeroes, ones);
                ones++;
                zeroes++;
            }else if(nums[ones] == 1){
                ones++;
            }else{
                swap(nums, ones, twos);
                twos--;
            }
        }
    }
}

