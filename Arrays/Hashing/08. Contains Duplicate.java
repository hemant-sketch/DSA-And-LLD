// Lc 217
// https://leetcode.com/problems/contains-duplicate/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vis = new HashSet<>();

        for(int val : nums){
            if(vis.contains(val) == true) return true;
            vis.add(val);
        }
        return false;
    }
}
