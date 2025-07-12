// https://www.geeksforgeeks.org/problems/three-way-partitioning/1

// TC = O(N)
// SC = O(1)  in place
// not stable 

class Solution {
    public void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    
    public void threeWayPartition(int arr[], int a, int b) {
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        
        while(j <= k){
            if(arr[j] < a){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[j] <= b){
                j++;
            }else{
                swap(arr, j, k);
                k--;
            }
        }
        
    }
}
