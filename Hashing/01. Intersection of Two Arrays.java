// Lc 349
// https://leetcode.com/problems/intersection-of-two-arrays/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int idx = 0; idx < nums1.length; idx++){
            freq.put(nums1[idx], freq.getOrDefault(nums1[idx], 0) + 1);
        }

        ArrayList<Integer> intersection = new ArrayList<>();
        
        for(int idx = 0; idx < nums2.length; idx++){
            if(freq.containsKey(nums2[idx]) == true){
                intersection.add(nums2[idx]);
                freq.remove(nums2[idx]);
            }
        }

        int[] ans = new int[intersection.size()];
        for(int idx = 0; idx < ans.length; idx++){
            ans[idx] = intersection.get(idx);
        }

        return ans;
    }
}
