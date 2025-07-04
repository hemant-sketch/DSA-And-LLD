// https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1

// TC = O(N*N)  //bohot hard reason why lol
// SC = O(1)

class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int left = 0;
        int right = n*n-1;
        int count  = 0;
        
        while(left < n*n && right >= 0){
            int r1 = left/n;
            int c1 = left%n;
            
            int r2 = right/n;
            int c2 = right%n;
            
            if(mat1[r1][c1] + mat2[r2][c2] == x){
                count++;
                left++;
                right--;
            }else if(mat1[r1][c1] + mat2[r2][c2] < x){
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}
