// https://www.geeksforgeeks.org/problems/find-first-repeated-character4108/1

// TC = O(N)
// SC = O(1) //26 hi hai constant
class Solution {
    String firstRepChar(String s) {
        int[] freq = new int[26]; 

        for (int idx = 0; idx < s.length(); idx++) {
            int index = s.charAt(idx) - 'a';

            freq[index]++;

            if (freq[index] == 2) {
                return String.valueOf(s.charAt(idx));
            }
        }

        return "-1";
    }
}
