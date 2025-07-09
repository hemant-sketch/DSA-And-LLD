// Lc 216
// https://leetcode.com/problems/contains-duplicate-ii/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> lastOcc = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++){
            if(lastOcc.containsKey(nums[idx]) == true && idx - lastOcc.get(nums[idx]) <= k){
                return true;
            }else{
                lastOcc.put(nums[idx], idx);
            }
        }
        return false;
    }
}
