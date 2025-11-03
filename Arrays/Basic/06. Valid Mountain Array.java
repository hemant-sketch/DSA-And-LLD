// Lc 941
// https://leetcode.com/problems/valid-mountain-array/description/

// TC = O(n)
// SC = O(1)

class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3) return false;
        int idx = 0;

        while(idx + 1 < arr.length){   //idx+1 aur idx kiu nahi kiuki neeche accessing idx+1
            if(arr[idx] == arr[idx+1]){
                return false;
            }
            else if(arr[idx] > arr[idx+1]){
                break;
            }
            idx++;
        }

        if(idx == 0) return false;
        if(idx == arr.length-1) return false;

        while(idx + 1 < arr.length){
            if(arr[idx] == arr[idx+1]){
                return false;
            }else if(arr[idx] < arr[idx+1]){
                return false;
            }
            idx++;
        }

        return true;
    }
}
