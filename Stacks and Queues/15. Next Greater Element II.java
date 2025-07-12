// Lc 503
// https://leetcode.com/problems/next-greater-element-ii/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[nums.length];
        Arrays.fill(nge, -1);

        for(int idx = 0; idx < nums.length; idx++){
            while(stk.size() > 0 && nums[stk.peek()] < nums[idx]){
                nge[stk.pop()] = nums[idx];
            }
            stk.push(idx);
        }

        for(int idx = 0; idx < nums.length; idx++){
            while(stk.size() > 0 && nums[stk.peek()] < nums[idx]){
                nge[stk.pop()] = nums[idx];
            }
        }

        return nge;
    }
}
