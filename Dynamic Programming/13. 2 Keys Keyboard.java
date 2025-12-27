// Lc 650
// https://leetcode.com/problems/2-keys-keyboard/description/

// Tc O(n^2)
// Sc O(n^2)

class Solution {
    public long memo(int screen, int buffer, int dest, long[][] dp) {
        if(screen > dest) return Integer.MAX_VALUE; //negative base case
        if(screen == dest) return 0;  //positive base case

        if(dp[screen][buffer] != -1) return dp[screen][buffer];

        long copyPaste = 2l + memo(screen*2, screen, dest, dp);
        long paste = 1l + memo(screen + buffer, buffer, dest, dp);

        return dp[screen][buffer] = Math.min(copyPaste, paste);
    }

    public int minSteps(int n) {
        if(n == 1) return 0;
        long[][] dp = new long[2*n][2*n];

        for(int screen = 0; screen < 2*n; screen++) {
            for(int buffer = 0; buffer < 2*n; buffer++) {
                dp[screen][buffer] = -1;
            }
        }

        return (int) (1 + memo(1, 1, n, dp)); // started with buffer = 1 not 0, kiuki upar paste mein screen + buffer if buffer = 0, toh same calls hence overflow.
    }
}
