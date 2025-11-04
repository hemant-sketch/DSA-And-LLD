// Lc 151
// https://leetcode.com/problems/reverse-words-in-a-string/

// Tc = O(N)
// Sc = O(1)

class Solution {
    public String reverseWords(String str) {
        String[] words = str.split("\s+");

        StringBuilder ans = new StringBuilder();
        for(int idx = words.length-1; idx >= 0; idx--) {
            ans.append(" " + words[idx]);
        }

        return ans.toString().trim();
    }
}
