// Lc 442
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

// TC = O(N)
// SC = O(1)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int idx = 0; idx < nums.length; idx++){
            int original = nums[idx] % (n+1);
            nums[original - 1] += (n+1);
        }
        for(int idx = 0; idx < nums.length; idx++){
            int freq = nums[idx] / (n+1);
            if(freq > 1){
                ans.add(idx+1);
            }
        }
        return ans;
    }
}
