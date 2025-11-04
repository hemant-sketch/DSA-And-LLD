// lc 557
// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

// Tc = O(n)
// Sc = O(n)

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\s+");

        StringBuilder ans = new StringBuilder();

        for(int idx  = 0; idx < words.length; idx++) {
            StringBuilder sb = new StringBuilder(words[idx]);
            sb.reverse();
            ans.append(sb.toString());
            if(idx < words.length - 1) {
                ans.append(' ');
            }
        }

        return ans.toString();
    }
}

// Tc = O(n)
// Sc = O(1)

class Solution {
    public void reverse(char[] str, int left, int right) {
        while(left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++; right--;
        }
    }

    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int left = 0;

        while(left < s.length()) {
            int right = left;
            while(right < s.length() && str[right] != ' '){
                right++;
            }

            reverse(str, left, right-1);
            left = right + 1;
        }

        return String.valueOf(str);
    }
}
