// Lc 560
// https://leetcode.com/problems/subarray-sum-equals-k/description/

// Brute force possible TLE
// TC = O(N^2)
// TC = O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}

// 243215-8251
// HashMap (Optimised)
// TC = O(N)
// TC = O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);   // very important line
        int sum = 0;
        int count = 0;
        
        for(int val : nums){
            sum += val;
            count += freq.getOrDefault(sum - k, 0);   // pehle hum count ke liye porrana search krre the but ab hum sum - k search krege 
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
