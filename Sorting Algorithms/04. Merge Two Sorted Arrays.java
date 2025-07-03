// https://www.naukri.com/code360/problems/ninja-and-sorted-arrays_1214628?leftPanelTab=0

// TC = O(N1 + N2)
// Sc = O(1)

import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] ninjaAndSortedArrays(int num1[], int num2[], int m, int n) {
        // Write your code here.
        int left = 0;
        int right = 0;
        int[] temp = new int[n+m];
        int idx = 0;
        while(left < m && right < n){
            if(num1[left] <= num2[right]){
                temp[idx++] = num1[left++];
            }else{
                temp[idx++] = num2[right++];
            }
            
        }
        while(left < m){
            temp[idx++] = num1[left++];
        }
        while(right < n){
            temp[idx++] = num2[right++];
        }
        return temp;
    }
}
