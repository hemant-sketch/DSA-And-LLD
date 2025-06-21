// https://leetcode.com/problems/spiral-matrix/

// TC = O(m*n)
// SC = O(1)

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int fr = 0;
        int lr = matrix.length-1;
        int fc = 0;
        int lc = matrix[0].length-1;

        while(true){

            for(int c = fc; c <= lc; c++){
                spiral.add(matrix[fr][c]);
            }
            fr++;
            if(fr > lr) break;

            for(int r = fr; r <= lr; r++){
                spiral.add(matrix[r][lc]);
            }
            lc--;
            if(fc > lc) break;

            for(int c = lc; c >= fc; c--){
                spiral.add(matrix[lr][c]);
            }
            lr--;
            if(fr > lr) break;

            for(int r = lr; r >= fr; r--){
                spiral.add(matrix[r][fc]);
            }
            fc++;
            if(fc > lc) break;
        }
        return spiral;
    }
}
