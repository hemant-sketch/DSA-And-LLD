// https://www.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1

//
//

class Solution {
    int memo(int noOfDigits, int prevDig, int[][] dp) {
        if(noOfDigits == 0) return 1;
        if(dp[noOfDigits][prevDig] != -1) return dp[noOfDigits][prevDig];
        
        int append0 = memo(noOfDigits-1, 0, dp);
        int append1 = prevDig == 0 ? memo(noOfDigits-1, 1, dp) : 0;
        
        return dp[noOfDigits][prevDig] = append0 + append1;
    }
    
    int countStrings(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int noOfDigits = 0; noOfDigits <= n; noOfDigits++) {
            for(int prevDig = 0; prevDig <= n; prevDig++) {
                dp[noOfDigits][prevDig] = -1;
            }
        }
        
        return memo(n, 0, dp);
    }
}
