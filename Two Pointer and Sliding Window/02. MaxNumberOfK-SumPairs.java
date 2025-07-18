// LC 1679
// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

// TC = O(N)
// SC = O(1)

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0 ;
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == k){
                count++;
                left++;
                right--;
            }
            else if(sum < k){
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}
