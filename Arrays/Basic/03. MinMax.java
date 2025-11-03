// https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/

// TC = O(n)
// SC = O(1)

public class Solution {
    public int solve(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int idx = 0; idx < A.length; idx++){
            min = Math.min(min, A[idx]); 
            max = Math.max(max, A[idx]);
        }
      
        return min + max;
    }
}
