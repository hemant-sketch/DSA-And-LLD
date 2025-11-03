// Lc 448 
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// Tc = O(2n)
// Sc = O(1)


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for(int idx = 0; idx < n; idx++) {
            int original = nums[idx] % (n+1);
            nums[original - 1] += (n+1);   // [1, n] to [0, n-1]
        }

        List<Integer> ans = new ArrayList<>();

        for(int idx = 0; idx < n; idx++) {
            int freq = nums[idx] / (n+1);
            if(freq == 0){
                ans.add(idx+1);
            }
        }

        return ans;
    }
}
