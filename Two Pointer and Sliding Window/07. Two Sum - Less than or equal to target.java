// Lintcode 609
// https://www.lintcode.com/problem/609

// TC = O(N)
// SC = O(1)

public class Solution {
    public int twoSum5(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int count = 0;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum > target){
                right--;
            }else{
                count += right - left;
                left++;
            }
        }
        return count;
    }
}    
