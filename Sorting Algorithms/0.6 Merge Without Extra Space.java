// https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

// TC = O(N1 + N2)
// SC = O(1)

// Par yeh TLE dega

class Solution {
    public void swap(int[] a, int[] b, int left , int right){
        int n1 = a.length;
        int n2 = b.length;
        
        if(left < n1 && right < n1){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }else if(left < n1 && right >= n1){
            int temp = a[left];
            a[left] = b[right - n1];
            b[right - n1] = temp;
        }else{
            int temp = b[left - n1];
            b[left - n1] = b[right - n1];
            b[right - n1] = temp;
        }
    }
    
    public int compare(int[] a, int[]b, int left, int right){
        int n1 = a.length;
        int n2 = b.length;
        
        int leftval = (left < n1) ? a[left] : b[left - n1];
        int rightval = (right < n1) ? a[right] : b[right - n1];
        
        if(leftval < rightval) return -1;
        else if(leftval > rightval) return +1;
        else return 0;
    }
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        
        for(int i = n1; i < n1+n2; i++){
            for(int j = i; j > 0; j--){
                if((compare(a, b, j-1, j)) > 0){
                    swap(a, b, j-1, j);
                }else{
                    break;
                }
            }
        }
    }
}
