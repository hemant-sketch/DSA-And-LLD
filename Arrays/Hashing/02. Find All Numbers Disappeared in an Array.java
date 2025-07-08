// Lc 448
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// TC = O(N)
// SC = O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int idx = 0; idx < nums.length; idx++) {
            int index = Math.abs(nums[idx]) - 1;   //jo already negative hogae honge unke liye yeh krre
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] > 0){
                ans.add(idx + 1);
            }
        }
        return ans;
    }
}
