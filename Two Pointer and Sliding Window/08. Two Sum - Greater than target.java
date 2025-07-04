// Lintcode 443
// https://www.lintcode.com/problem/443

// TC = O(N)
// SC = O(1)

public class Solution {
    public int twoSum2(int[] nums, int target) {
        // write your code here
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
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
}
