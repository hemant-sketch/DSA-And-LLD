// Lc 1190
// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder open = new StringBuilder("(");
        Stack<StringBuilder> stk = new Stack<>();

        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);

            if(ch == ')'){
                StringBuilder str = new StringBuilder("");
                while(stk.peek() != open){
                    StringBuilder top = stk.pop();
                    top.reverse();
                    str.append(top);
                }
                stk.pop();  //open removal
                stk.push(str);

            }else if(ch == '('){
                stk.push(open);
            }else{

                if(stk.size() == 0 || stk.peek() == open){
                    stk.push(new StringBuilder(ch + ""));
                }else{
                    stk.peek().append(ch);
                }

            }
        }
        StringBuilder res = new StringBuilder("");
        while(stk.size() > 0){
            StringBuilder top = stk.pop();
            top.reverse();
            res.append(top);
        }

        return res.reverse().toString();
    }
}
