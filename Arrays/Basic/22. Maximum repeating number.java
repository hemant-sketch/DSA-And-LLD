// https://www.geeksforgeeks.org/problems/maximum-repeating-number4858/1

// Tc = O(n)
// Sc = O(1)

class Solution {
    int maxRepeating(int k, int[] arr) {
        for(int idx = 0; idx < arr.length; idx++) {
            int original = arr[idx] % (k+1);
            arr[original] += (k+1);
        }
        
        int maxRep = 0;
        int maxFreq = 0;
        
        for(int idx = 0; idx < arr.length; idx++) {
            int freq = arr[idx] / (k+1);
            if(freq > maxFreq) {
                maxFreq = freq;
                maxRep = idx;
            }
        }
        
        return maxRep;
        
    }
}
