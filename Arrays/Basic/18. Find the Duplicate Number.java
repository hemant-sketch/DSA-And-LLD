// Lc 287
// https://leetcode.com/problems/find-the-duplicate-number/description/

// Tc = O(2n)
// Sc = O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int idx = 0; idx < n; idx++) {
            int original = nums[idx] % (n+1);
            nums[original] += (n+1);
        }

        for(int idx = 0; idx < n; idx++) {
            int freq = nums[idx] / (n+1);
            if(freq > 1){
                return idx;
            }
        }

        return n;
    }
}
