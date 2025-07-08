// Lc 350
// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

// TC = O(N1 + N2)
// SC = O(N1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int idx = 0; idx < nums1.length; idx++){
            freq.put(nums1[idx], freq.getOrDefault(nums1[idx], 0) + 1);
        }

        ArrayList<Integer> intersection = new ArrayList<>();
        
        for(int idx = 0; idx < nums2.length; idx++){
            if(freq.containsKey(nums2[idx]) == true && freq.get(nums2[idx]) > 0){
                intersection.add(nums2[idx]);
                freq.put(nums2[idx], freq.getOrDefault(nums2[idx], 0) - 1);
            }
        }

        int[] ans = new int[intersection.size()];
        for(int idx = 0; idx < ans.length; idx++){
            ans[idx] = intersection.get(idx);
        }

        return ans;
    }
}
