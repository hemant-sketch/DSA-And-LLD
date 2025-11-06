// Lc 43
// https://leetcode.com/problems/multiply-strings/

// TC = O(n2)  kiuki add mein bhi poora tarveral hai fir multiply mien bhi
// Sc = O(n) har funtion mein ek new sb banra hai

class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0 || carry > 0) {
            int dig1 = (p1 >= 0 ? num1.charAt(p1) - 48 : 0);
            int dig2 = (p2 >= 0 ? num2.charAt(p2) - 48 : 0);
            int sum = dig1 + dig2 + carry;

            carry = sum / 10;
            sb.append(sum % 10);

            p1--; p2--;
        }

        return sb.reverse().toString();
    }

    public String multiply(String s, int d) {
        int pointer = s.length()-1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(pointer >= 0 || carry > 0) {
            int digit = pointer >= 0 ? (s.charAt(pointer) - 48) : 0;
            int prod = digit * d + carry;

            sb.append(prod % 10);
            carry = prod / 10;
            pointer--;
        }

        return sb.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        int pointer = num2.length()-1;
        int count = 0;
        
        String ans = "0";

        while(pointer >= 0) {
            int digit = num2.charAt(pointer) - 48;

            String temp = multiply(num1, digit);

            for(int c = 0; c < count; c++) {
                temp += "0";
            } 

            ans = addStrings(temp, ans);
            count++;
            pointer--;
        }

        if(ans.charAt(0)=='0') return "0";
        return ans;
    // return multiply("123", 456);
    // return addStrings("4", "4");
    }
    
}
