// Lc 268
// https://leetcode.com/problems/missing-number/

// TC = O(N)
// SC = O(N)

class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int val : nums){
            st.add(val);
        }

        for(int idx = 0; idx < nums.length; idx++){
            if(st.contains(idx) == false){
                return idx;
            }
        }
        return nums.length;
    }
}
