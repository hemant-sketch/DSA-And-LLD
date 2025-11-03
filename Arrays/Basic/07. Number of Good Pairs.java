// Lc 1512
// https://leetcode.com/problems/number-of-good-pairs/

// TC = O(n^2)
// SC = O(1)

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
