// Lc 220
// https://leetcode.com/problems/contains-duplicate-iii/description/

// TC = O(N*logk)
// SC = O(k)

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> vis = new TreeSet<>();

        for(int idx  = 0; idx < nums.length; idx++){
            if((idx - k -1) >= 0){
                vis.remove((long)nums[idx-k-1]);
            }

            Long floor = vis.floor((long)nums[idx]); 
            Long ceil = vis.ceiling((long)nums[idx]);

            if(floor != null && (long)nums[idx] - floor <= t){
                return true;
            }

            if(ceil != null && ceil - (long)nums[idx] <= t){
                return true;
            }

            vis.add((long)nums[idx]);
        }
        return false;
    }
}
