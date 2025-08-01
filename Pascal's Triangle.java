// Lc 118
// https://leetcode.com/problems/pascals-triangle/description/?envType=daily-question&envId=2025-08-01

// TC = O(N^2)
// SC = O(N^2)

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if(numRows == 1) return result;

        for(int idx1= 1; idx1 < numRows; idx1++) {
            List<Integer> prevRow = result.get(idx1 - 1);

            List<Integer> currentRow =  new ArrayList<>();

            currentRow.add(1);
            for(int idx2 = 1; idx2 < idx1; idx2++){
                currentRow.add(prevRow.get(idx2) + prevRow.get(idx2 - 1));
            }
            currentRow.add(1);

            result.add(currentRow);
        }
        return result;
    }
}
