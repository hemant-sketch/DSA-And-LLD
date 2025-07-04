// LintCode 587
// https://www.lintcode.com/problem/587/

// TC = O(N)
// SC = O(1)

public class Solution {
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            if(left > 0 && nums[left - 1] == nums[left]){
                left++;
                continue;
            } 
            int sum = nums[left] + nums[right];
            if(sum == target){
                count++;
                left++;
                right--;           
            }
            else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return count;
    }
}
