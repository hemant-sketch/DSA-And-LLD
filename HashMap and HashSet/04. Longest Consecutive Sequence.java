// Lc 128
// https://leetcode.com/problems/longest-consecutive-sequence/description/

// Two Pointer
// TC = O(N*logN)
// SC = O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int left = 0, max = 0;

        while(left < nums.length){
            int right = left + 1;

            int count = 1;
            while(right < nums.length && nums[right] <= nums[right-1] + 1){
                if(nums[right] == nums[right-1]+1){
                    count++;
                }
                right++;
            }

            max = Math.max(max, count);
            left = right;
        }
        return max;
    }
}

// Hashset
// TC = O(N)
// SC = O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int res = 0;

        for(int val : nums){
            st.add(val);
        }

        for(int val : nums){
            while(st.contains(val) && !st.contains(val-1)){
                int curr = val;
                int count = 0;
                while(st.contains(curr)){
                    st.remove(curr);
                    curr++;
                    count++;
                }

                res = Math.max(res, count);
            }
        }
        return res;
    }
}
