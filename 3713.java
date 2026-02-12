class Solution {
    public boolean check(int[] freq) {
        int common = 0;

        for(int idx = 0; idx < 26; idx++) {
            if(freq[idx] == 0) continue;
            if(common == 0) {
                common = freq[idx];
            } else if(freq[idx] != common) {
                return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                if(check(freq)){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}
