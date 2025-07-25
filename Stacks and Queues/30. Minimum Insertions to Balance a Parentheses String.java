// Lc 1541
// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

// TC = O(N)
// SC = O(1)

class Solution {
    public int minInsertions(String s) {
        int open = 0, close = 0;

        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);

            if(ch == '('){
                open++;
            }else if(ch == ')'){
                if(open > 0) open--;
                else close++;

                if(idx+1 < s.length() && s.charAt(idx+1) == ')'){
                    idx++;
                }else{
                    close++;
                }
            }            
        }

        return close + 2*open;
    }
}
