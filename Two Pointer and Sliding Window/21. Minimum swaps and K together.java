// https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

// TC = O(N)
// SC = O(1)

class Solution {
    int minSwap(int[] arr, int k) {
       int window = 0;
       for(int idx = 0; idx < arr.length; idx++){
           if(arr[idx] <= k){
               window++;
           }
       }
       
       int moreThank = 0;
       for(int idx = 0; idx < window; idx++){
           if(arr[idx] > k){
               moreThank++;
           }
       }
       
       int minSwaps = moreThank;
       for(int idx = window; idx < arr.length; idx++){
           if(arr[idx] > k){
               moreThank++;
           }
           if(arr[idx - window] > k){
               moreThank--;
           }
           minSwaps = Math.min(minSwaps, moreThank);
       }
       return minSwaps;
       
    }
}
