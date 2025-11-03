// Lc 238
// https://leetcode.com/problems/product-of-array-except-self/

// Tc = O(n)
// Sc = O(n)

class Solution {
    public int[] getPrefix(int[] nums){
        int[] prefix = new int[nums.length];
        for(int idx=0; idx<nums.length; idx++){
            prefix[idx] = nums[idx] * ((idx > 0) ? prefix[idx-1] : 1);
        }
        return prefix;
    }
    public int[] getSuffix(int[] nums){
        int[] suffix = new int[nums.length];
        for(int idx=nums.length-1; idx>=0; idx--){
            suffix[idx] = nums[idx] * ((idx < nums.length-1) ? suffix[idx+1] : 1);
        }
        return suffix;
    }
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = getPrefix(nums);
        int[] suffix = getSuffix(nums);
        int[] ans = new int[nums.length];
        for(int idx = 0; idx<nums.length-1; idx++){
            int left = (idx > 0) ? prefix[idx - 1] : 1;
            int right = (idx < nums.length-1) ? suffix[idx + 1] : 1;
            ans[idx] =  left * right;
        }
        return ans;
    }
}
