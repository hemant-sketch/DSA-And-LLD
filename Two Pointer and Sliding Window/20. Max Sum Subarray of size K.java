// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

// TC = O(N)
// SC = O(1)

// https://www.interviewbit.com/problems/distinct-numbers-in-window/        hashmap se hoga  1704 59min
//

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int currSum = 0;
        for(int idx = 0; idx < k; idx++){
            currSum += arr[idx];
        }
        
        int maxSum = currSum;
        for(int idx = k; idx < n; idx++){
            int inc = arr[idx];
            int exc = arr[idx - k];
            currSum = currSum + inc - exc;
            
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
