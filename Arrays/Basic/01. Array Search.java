// https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1
// TC = O(n)
// SC = O(1)
// for last occurance right to left loop


class Solution {
    public int search(int arr[], int x) {
        int ans = -1;
        
        for(int idx = 0; idx < arr.length; idx++) {
            if(arr[idx] == x) {
               return idx;
            }
        }
        
        return ans;
    }
}


OR

class Solution {
    public int search(int arr[], int x) {
        int ans = -1;
        
        for(int idx = 0; idx < arr.length; idx++) {
            if(arr[idx] == x) {
                if(ans == -1) {
                    ans = idx;
                }
            }
        }
        if(ans == -1) return -1;
        return ans;
        
    }
}
