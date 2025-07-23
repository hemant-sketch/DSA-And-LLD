// https://www.geeksforgeeks.org/problems/count-the-reversals0401/1

// Tc = O(N)
// SC = O(1)

class Solution {
    public int countMinReversals(String s) {
        // code here
        int open = 0;
        int close = 0;
        
        for(char ch : s.toCharArray()){
            if(ch=='{'){
                open++;
            }else{
                if(open > 0) open--;
                else close++;
            }
        }
        
        int sum = open + close;
        if (sum % 2 == 1) return -1;
        if(open % 2 == 1) return sum/2 + 1;
        return sum/2;
    }
}
