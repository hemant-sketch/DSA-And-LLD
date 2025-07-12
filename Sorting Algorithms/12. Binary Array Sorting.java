// https://www.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1

// brute - frequency coi=unt krke but O(2N)

// TC = O(N)
// SC = O(1)

class Solution {
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    // Function to sort the binary array in non-decreasing order
    public void binSort(int[] nums) {
        // code here
        int left = 0;
        int right = 0;

        while(right < nums.length){
            if(nums[right] < 1){
                swap(nums, left, right);
                left++;
                right++;
            }else{
                right++;
            }
        }
        
    }
}
