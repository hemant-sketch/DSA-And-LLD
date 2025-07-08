// Lc 448
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int val : nums){
            st.add(val);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int idx = 1; idx <= nums.length; idx++){
            if(st.contains(idx) == false){
                ans.add(idx);
            }
        }
        return ans;
    }
}
