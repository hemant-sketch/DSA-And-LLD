// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

// TC = O(N)
// SC = O(1)

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int ans = 0;
        for(int idx = 1; idx < n; idx++){
            if(mat[idx][ans] == 0){
                ans = idx;
            }
        }
        for(int idx = 0; idx < n; idx++){
            if(idx == ans) continue;
            if(mat[ans][idx] != 0) return -1;
            if(mat[idx][ans] != 1) return -1;
        }
        return ans;
    }
}
