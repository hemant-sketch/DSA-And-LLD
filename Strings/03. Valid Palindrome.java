// Lc 125
// https://leetcode.com/problems/valid-palindrome/description/

// Tc = O(n);
// Sc = O(1);

class Solution {
    public boolean isAlphanumeric(char ch) {
        if(ch >= 'a' && ch <= 'z') return true;
        if(ch >= 'A' && ch <= 'Z') return true;
        if(ch >= '0' && ch <= '9') return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(!isAlphanumeric(s.charAt(left))) {
                left++; continue;
            }

            if(!isAlphanumeric(s.charAt(right))) {
                right--; continue;
            }

            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
