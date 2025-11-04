// Lc 151
// https://leetcode.com/problems/reverse-words-in-a-string/

// Tc = O(N)
// Sc = O(N)

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

// Tc = O(N)
// Sc = O(1)

class Solution {
    public String reverseWords(String s) {
        int right = s.length()-1;
        StringBuilder ans = new StringBuilder();

        while(right >= 0) {

            while(right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            int left = right;

            while(left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            if(ans.length() > 0 && left < right) {
                ans.append(' ');
            }

            for(int idx = left + 1; idx <= right; idx++) { 
                ans.append(s.charAt(idx));
            }

            right = left;
        }
        return ans.toString();

    }
}
