// Ts = O(n) 
// Sc = O(1)

// imporvements to be made here - if num2 > num1

class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int borrow = 0;
        StringBuilder sb = new StringBuilder();

        while(p1 >= 0 || p2 >= 0) {
            int dig1 = (p1 >= 0 ? num1.charAt(p1) - 48 : 0);
            int dig2 = (p2 >= 0 ? num2.charAt(p2) - 48 : 0);
            int diff = borrow + dig1 - dig2;

            if(diff < 0) {
              diff += 10;
              borrow = -1;
            }else{
              borrow = 0;
            }
          
            sb.append(diff % 10);

            p1--; p2--;
        }

        return sb.reverse().toString();
    }
}
