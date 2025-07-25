// Lc 856
// https://leetcode.com/problems/score-of-parentheses/description/

// TC = O(N)
// SC = O(N)

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();

        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);

            if(ch == '('){
                stk.push(-1);
            }else{

                int ans = 0;
                while(stk.peek() != -1){
                    ans += stk.pop();
                }
                stk.pop();

                if(ans == 0) stk.push(1);
                else stk.push(2 * ans);
            }
        }
        int ans = 0;
        while(stk.size() > 0){
            ans += stk.pop();
        }

        return ans;
    }
}
