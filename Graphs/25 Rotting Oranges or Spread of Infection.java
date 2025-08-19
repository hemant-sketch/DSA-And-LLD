// Lc 994
// https://leetcode.com/problems/rotting-oranges/description/

//TC =O(N^2)
//SC =O(N^2)

class Solution {
    static class Pair{
        int row, col, time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int bfs (Queue<Pair> q, int[][]grid){
        int time = 0;
        while(q.size() > 0){
            Pair p = q.remove();
            time = Math.max(time, p.time);

            for(int d = 0; d < 4; d++){
                int r = p.row + dx[d];
                int c = p.col + dy[d];

                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) continue;

                grid[r][c] = 2;
                q.add(new Pair(r, c, p.time + 1));
            }
        }
        return time;
    }    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    q.add(new Pair(row, col, 0));
                }
            }
        }

        int ans = bfs(q, grid);

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}
