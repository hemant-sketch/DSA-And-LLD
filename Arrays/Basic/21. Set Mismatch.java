// lc 645
// https://leetcode.com/problems/set-mismatch/

// Tc = O(2n)
// Sc = O(1)

class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        for(int idx = 0; idx < n; idx++){
            int original = nums[idx] % (n+1);
            nums[original-1] += (n+1);
        }

        int[] ans = new int[2];

        for(int idx = 0; idx < n; idx++){
            int freq = nums[idx] / (n+1);
            if(freq > 1){
                ans[0] = idx+1;
            }else if(freq == 0){
                ans[1] = idx+1;
            }

        }
        return ans;
        
    }

}
