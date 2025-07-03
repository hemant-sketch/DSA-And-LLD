// Lc 88
// https://leetcode.com/problems/merge-sorted-array/description/

// TC = O(N+M)
// SC = O(1)

class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        int left = m-1;
        int right = n-1;
        int idx = m + n - 1;
        while(left >= 0 && right >= 0){
            if(num1[left] > num2[right]){
                num1[idx--] = num1[left--];
            }else{
                num1[idx--] = num2[right--];
            }
            
        }
        // left wala isliye hatay kiuki usme toh ans aara toh woh khtm nhi hoga
        while(right >= 0){
            num1[idx--] = num2[right--];
        }
    }
}+
