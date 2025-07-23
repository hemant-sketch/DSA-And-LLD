// Lc 316
// https://leetcode.com/problems/remove-duplicate-letters/description/

// TC = O(N)
// SC = O(26) O(1) 

// acfdbafc

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] present = new boolean[26];

        char[] chs = s.toCharArray();
        for(char ch : chs) freq[ch - 'a']++;

        StringBuilder res = new StringBuilder();

        for(char ch : chs){
            freq[ch-'a']--;
            if(present[ch-'a'] == true) continue;
            present[ch-'a'] = true;

            while(res.length() > 0){
                int top = res.charAt(res.length()-1);
                if(top > ch && freq[top-'a'] > 0){
                    res.deleteCharAt(res.length()-1);
                    present[top-'a'] = false;
                }else break;
            }
            res.append(ch);
        }
        return res.toString();
    }
}
