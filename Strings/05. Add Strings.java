// Lc 415
// https://leetcode.com/problems/add-strings/description/

// Tc = O(n)
// Sc = O(1)

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
}
