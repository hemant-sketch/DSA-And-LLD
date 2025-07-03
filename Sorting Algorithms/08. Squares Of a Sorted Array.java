// Lc 779
// https://leetcode.com/problems/squares-of-a-sorted-array/description/

// TC = O(N)
// SC = O(1)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res =new int[nums.length];
        int idx = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                res[idx--] = nums[left]*nums[left];
                left++;
            }else{
                res[idx--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
