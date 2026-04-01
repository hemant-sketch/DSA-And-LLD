class Solution { 
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void dfs(char[][] board, int row, int col) {
        board[row][col] = '#';
        for(int idx = 0; idx < 4; idx++) {
            int newRow = row + dx[idx];
            int newCol = col + dy[idx];

            if(newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length && board[newRow][newCol] == 'O'){
                dfs(board, newRow, newCol);
            }
        }
    }

    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if(board[i][j] == 'O') dfs(board, i, j);
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        // for(int i = 0; i < board.length; i++) {
        //     for(int j = 0; j < board[0].length; j++) {
                
        //     }
        // }
    }
}
