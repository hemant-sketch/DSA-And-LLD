// using % 10 method to get the digits of a number has TC of O(log10 n)

class Main {
    public static void main(String[] args) {
        int n = 2345;
        
        System.out.println(Math.log10(n) + 1);
        System.out.println((int)Math.log10(n) + 1);
    }
}

// output
4.370142847051103
4
