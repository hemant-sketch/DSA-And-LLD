// Lc 242
// https://leetcode.com/problems/valid-anagram/description/

// Tc = O(26) which is constant only
// Sc = O(26) size of the freq arrays which is again constant

class Solution {
    public int[] getFreq (String s) {
        int[] freq = new int[26];  //agr saare symbols hote toh 128 size best rehta

        for(int idx = 0; idx < s.length(); idx++) {
            freq[s.charAt(idx) - 'a']++ ;
        }

        return freq;

    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq1 = getFreq(s);
        int[] freq2 = getFreq(t);

        for(int idx = 0; idx < freq1.length; idx++) {
            if(freq1[idx] != freq2[idx]) return false;
        }

        return true;
    }
}
