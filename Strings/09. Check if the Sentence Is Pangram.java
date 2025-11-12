// Lc 1832
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/

// Tc = O(26)
// Sc = O(26)

class Solution {

    public int[] getFreq (String s) {
        int[] freq = new int[26];  //agr saare symbols hote toh 128 size best rehta

        for(int idx = 0; idx < s.length(); idx++) {
            freq[s.charAt(idx) - 'a']++ ;
        }

        return freq;

    }

    public boolean checkIfPangram(String sentence) {
        int[] freq = getFreq(sentence);

        for(int idx = 0; idx < freq.length; idx++) {
            if(freq[idx] <= 0) return false;
        }

        return true;
    }
}
