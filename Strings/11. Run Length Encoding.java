// https://www.geeksforgeeks.org/problems/run-length-encoding/1

// Tc = O(2N)
// Sc = O(1)

class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        
        int left = 0; int right = 0;
        while(left < s.length()) {
            char ch = s.charAt(left);
            int freq = 0;
            
            while(right < s.length() && s.charAt(right) == ch) {
                freq++;
                right++;
            }
            
            ans.append(ch);
            // if(freq > 1) {      // agar 1 par freq nahi daalni ho toh
            //     ans.append(freq);
            // }
            ans.append(freq);
            left = right;
        }
        
        return ans.toString();
        
        
    }
}
