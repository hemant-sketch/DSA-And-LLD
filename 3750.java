class Solution {
    public int minimumFlips(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        
        while (n > 0) {
            digits.add(n % 2);
            n /= 2;
        }
        
        int left = 0, right = digits.size() - 1;
        int res = 0;
        
        while (left < right) {
            if (!digits.get(left).equals(digits.get(right))) {
                res += 2;
            }
            left++;
            right--;
        }
        
        return res;
    }
}
