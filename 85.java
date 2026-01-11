class Solution {
    public int[] rightNSE(int[] heights) {
        Stack<Integer> stk = new Stack();
        int[] res = new int[heights.length];

        for(int idx = heights.length-1; idx >= 0; idx--) {
            while(stk.size() != 0 && heights[stk.peek()] >= heights[idx]) {
                stk.pop();
            }
            res[idx] = stk.size() > 0 ? stk.peek() : heights.length;
            stk.push(idx);
        }
        return res;
    }

    public int[] leftNSE(int[] heights) {
        Stack<Integer> stk = new Stack();
        int[] res = new int[heights.length];

        for(int idx = 0; idx < heights.length; idx++) {
            while(stk.size() != 0 && heights[stk.peek()] >= heights[idx]) {
                stk.pop();
            }
            res[idx] = stk.size() > 0 ? stk.peek() : -1;
            stk.push(idx);
        }
        return res;
    }

    public int largestAreaHistogram(int[] heights) {
        int[] left = leftNSE(heights);
        int[] right = rightNSE(heights);
        int max = Integer.MIN_VALUE;

        for(int idx = 0; idx < heights.length; idx++) {
            max = Math.max(max, heights[idx]*(right[idx] - left[idx] - 1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        
        for(int idx = 0; idx < matrix[0].length; idx++) {
            heights[idx] = matrix[0][idx] == '1' ? 1 : 0;
        }

        int maxArea = largestAreaHistogram(heights);

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestAreaHistogram(heights));
        }
        return maxArea;
    }
}
