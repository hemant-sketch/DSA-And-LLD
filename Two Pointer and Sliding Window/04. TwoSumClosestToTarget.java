// Lintcode 533
// https://www.lintcode.com/problem/533/

// TC = O(N)
// SC = O(1)

public class Solution {
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return 0;
            }
            else if(target > sum){
                minDiff = Math.min(minDiff, target - sum);
                left++;
            }else{
                minDiff = Math.min(minDiff, sum - target);
                right--;
            }
        }
        return minDiff;
    }
}
