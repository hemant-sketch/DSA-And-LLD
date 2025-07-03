// Lc 912
// https://leetcode.com/problems/sort-an-array/description/

// TC = O(N*logN)
// SC = O(1)

class Solution {
    public int[] merge(int[] larr, int[] rarr){
        int left = 0;
        int right = 0;
        int idx = 0;
        int[] res = new int[larr.length + rarr.length];

        while(left < larr.length && right < rarr.length){
            if(larr[left] <= rarr[right]){
                res[idx++] = larr[left++];
            }else{
                res[idx++] =  rarr[right++];
            }
        }

        while(left < larr.length){
            res[idx++] = larr[left++];
        }

        while(right < rarr.length){
            res[idx++] = rarr[right++];
        }  

        return res;
    }
    public int[] mergeSort(int[] nums, int left, int right){
        if(left == right){
            return new int[] {nums[left]};
        }
        int mid = left + (right-left)/2;
        int[] larr = mergeSort(nums, left, mid); 
        int[] rarr = mergeSort(nums, mid+1, right); 
        return merge(larr, rarr);
    }
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}
