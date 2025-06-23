// Lc 733
// https://leetcode.com/problems/flood-fill/description/

// TC = O(m*n)
// SC = O(m*n)

class Solution {

    public void dfs(int[][] image, int row, int col, int newColor, int oldColor){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;

        if(image[row][col] != oldColor) return;  //kiuki changes toh oldColor mein hi honge na

        image[row][col] = newColor;

        dfs(image, row - 1, col, newColor, oldColor);
        dfs(image, row + 1, col, newColor, oldColor);
        dfs(image, row , col - 1, newColor, oldColor);
        dfs(image, row , col + 1, newColor, oldColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        if(newColor != oldColor){
            dfs(image, sr, sc, newColor, oldColor);
        }

        return image;
    }
}

