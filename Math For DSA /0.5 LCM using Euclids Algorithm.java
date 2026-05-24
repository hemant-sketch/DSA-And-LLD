public class Solution {
  public static int gcd(int a, int b) {
        if(b == 0) return a;
        
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        int a = 6;
        int b = 12;
        System.out.println((a*b) / gcd(a, b));  // lcm(a,b) * hcf(a,b) = a*b
    }
}
