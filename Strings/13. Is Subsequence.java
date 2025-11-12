// Lc 392
// https://leetcode.com/problems/is-subsequence/

// Tc = O(N)
// Sc = O(1)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0; int p2 = 0;

        while(p1 < s.length() && p2 < t.length()) {
            if(s.charAt(p1) == t.charAt(p2)) {
                p1++; p2++;
            }else {
                p2++;
            }
        }

        return p1 == s.length();
    }
}
