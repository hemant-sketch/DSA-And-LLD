// Lc - 200
// https://leetcode.com/problems/number-of-islands/

// TC = O(n^2)
// SC = O(n^2)

class Solution {
    int[] dx = {-1, +1, 0, 0};
    int[] dy = {0, 0, -1, +1}; 

    public void dfs(char[][] grid, int row, int col){
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0) return;

        if(grid[row][col] == '0' || grid[row][col]  == '2') return;

        grid[row][col] = '2';

        for(int idx = 0; idx < 4; idx++){
            dfs(grid, row + dx[idx], col + dy[idx]);
        }
    }
    public int numIslands(char[][] grid) {
        int islands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }
}
