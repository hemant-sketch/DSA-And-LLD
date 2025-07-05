// https://www.geeksforgeeks.org/problems/count-the-triplets4615/1

// TC = O(N^2)
// SC = O(logN)


class Solution {
    public int countTwoSum(int[] arr, int left, int right, int target){
        int count = 0;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                count++;
                left++;
                right--;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return count++;
    }
    
    int countTriplet(int arr[]) {
        Arrays.sort(arr);
        int count = 0; 
        for(int last = arr.length-1; last > 1; last--){
            count += countTwoSum(arr, 0, last-1, arr[last]);
        }
        return count;
    }
}
