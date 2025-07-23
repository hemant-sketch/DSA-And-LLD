// Lc 921
// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

// TC =(1)
// SC =(1)

// ))())()(())((( ans 3

class Solution {
    public int minAddToMakeValid(String s) {
        int unbalancedOpen = 0, unbalancedClose = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(') unbalancedOpen++;
            else{
                if(unbalancedOpen > 0) unbalancedOpen--;
                else unbalancedClose++;
            }
        }
        return unbalancedOpen + unbalancedClose;
    }
}

