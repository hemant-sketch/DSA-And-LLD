// Lc 1021
// https://leetcode.com/problems/remove-outermost-parentheses/description/

// TC = O(N) 
// SC = O(N)

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        boolean[] isOuter = new boolean[s.length()];
        
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) == '('){
                stk.push(idx);
            }else{
                int open = stk.pop();
                if(stk.size() == 0){
                    isOuter[idx] = isOuter[open] = true;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for(int idx = 0; idx < isOuter.length; idx ++){
            if(isOuter[idx] == false){
                res.append(s.charAt(idx));
            }
        }
        return res.toString();
    }
}


