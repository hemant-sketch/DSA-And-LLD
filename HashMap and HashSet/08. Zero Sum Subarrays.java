// https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1

// brute force TLE dega
// TC = O(N^2)
// SC = O(1)
class Solution {
    public int findSubarray(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                if(sum == 0) count++;
            }
        }
        return count;
    }
}

// optimised
// TC = O(N)
// SC = O(N)
class Solution {
    public int findSubarray(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);   // very important line  //ki ek khali subarray aara hai with sum = 0 //jab hum ek bhi element nhi lere gote tab to prefix sum zero hi aata na
        int sum = 0;
        int count = 0;
        
        for(int val : arr){
            sum += val;
            count += freq.getOrDefault(sum, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
