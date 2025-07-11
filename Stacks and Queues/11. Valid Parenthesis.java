// Lc 20
// https://leetcode.com/problems/valid-parentheses/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            }else{
                if(stk.size() == 0) return false;
                if(ch == ')' && stk.peek() == '(') stk.pop();
                else if(ch == '}' && stk.peek() == '{') stk.pop();
                else if(ch == ']' && stk.peek() == '[') stk.pop();
                else return false;
            }

            
        }
        return stk.size() == 0;
    }
}
