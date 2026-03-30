class Solution {
    private static final int INF = 2147483647;

    public class Pair {
        int row, col, dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;

        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        while (q.size() > 0) {
            Pair pair = q.remove();

            for (int d = 0; d < 4; d++) {
                int row = pair.row + dr[d];
                int col = pair.col + dc[d];

                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == INF) {
                    grid[row][col] = pair.dist + 1;
                    q.add(new Pair(row, col, pair.dist + 1));
                }
            }
        }
    }
}




