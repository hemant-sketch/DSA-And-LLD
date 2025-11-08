// Lc 1137
// https://leetcode.com/problems/n-th-tribonacci-number/description/

// memoization hw bsdk

// tabulation hw bsdk

// tabulation optimised

// Tc = O(n)
// Sc = O(1)

class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        int prev1 = 1;
        int prev2 = 1;
        int prev3 = 0;

        for(int idx = 3; idx <= n; idx++) {
            int curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
