// Lc 264
// https://leetcode.com/problems/ugly-number-ii/description/

// TC O(n)
// SC O(n)

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;

        // yeh indices hai naaki values
        int ptr2 = 0;
        int ptr3 = 0;
        int ptr5 = 0;

        ArrayList<Integer> ugly = new ArrayList<>();
        ugly.add(1);

        for(int idx = 1; idx < n; idx++) {
            int a = ugly.get(ptr2) * 2;
            int b = ugly.get(ptr3) * 3;
            int c = ugly.get(ptr5) * 5;

            int min = Math.min(a, Math.min(b,c));
            ugly.add(min);

            // yeh kiuki kahi values repeat ho toh dono ++, eg 2*3 & 3*2
            if(min == a) ptr2++;
            if(min == b) ptr3++;
            if(min == c) ptr5++;
        }

        return ugly.get(n-1);
    }
}
