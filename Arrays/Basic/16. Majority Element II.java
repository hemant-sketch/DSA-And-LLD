// Lc 229
// https://leetcode.com/problems/majority-element-ii/

// Tc = O(n)
// Sc = O(1)

class Solution {
    public boolean isActualAnswer(int[] nums, int target){
        int n = nums.length;
        int count = 0;
        for(int val : nums){
            if(val == target){
                count++;
            }
        }
        if (count > n/3) return true;
        else return false;
    }
    public List<Integer> majorityElement(int[] nums) {
        int majA = Integer.MAX_VALUE, leadA = 0;
        int majB = Integer.MIN_VALUE, leadB = 0;
        List<Integer> ans = new ArrayList<>();
        for(int val : nums){
            if(val == majA){
                leadA++;
            }else if(val == majB){
                leadB++;
            }else if(leadA == 0){
                majA = val;
                leadA = 1;
            }else if(leadB == 0){
                majB = val;
                leadB = 1;
            }else{
                leadA--;
                leadB--;
            }
        }
    if(isActualAnswer(nums,majA) == true) ans.add(majA);
    if(isActualAnswer(nums,majB) == true) ans.add(majB);
    return ans;
    }
}
