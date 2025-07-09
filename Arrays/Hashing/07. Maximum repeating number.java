// https://www.geeksforgeeks.org/problems/maximum-repeating-number4858/1

// TC = O(N)
// SC = O(1)

class Solution {
    int maxRepeating(int k, int[] arr) {
        for(int idx = 0; idx < k; idx++){
            int original = arr[idx] % (k+1);
            arr[original] += (k+1);
        }
        
        int maxFreq = 0;
        int maxRepeating = 0;
        for(int idx = 0; idx < k; idx++){
            int freq = arr[idx] / (k+1);
            if(freq > maxFreq){
                maxFreq = freq;
                maxRepeating = idx;
            }
        }
        return maxRepeating;
    }
}
