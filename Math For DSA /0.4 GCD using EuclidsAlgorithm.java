// O(log(min(a,b))

class Main {

  // iterative method
    public static int gcd(int a, int b) {
        while(a > 0 && b > 0){
            if(a>b){
                a = a%b;
            }else{
                b = b%a;
            }
        }
        if(a == 0) return b;
        else return a;
    }

  // recursive method
  //assuming a > b
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        int a = 20;
        int b = 28;
        System.out.println(gcd(6, 12));
    }
}
