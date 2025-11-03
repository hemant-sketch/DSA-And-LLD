// Lc 1413
// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/


// Tc = O(n)
// Sc = O(1)

class Solution {
    public int minStartValue(int[] nums) {
        int sum = 1;
        int start = 1;

        for(int val : nums) {
            sum += val;
            if(sum <= 0) {
                start += (1-sum);
                sum = 1;
            }
        }

        return start;
    }
}
