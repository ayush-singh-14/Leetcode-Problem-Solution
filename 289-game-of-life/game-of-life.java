class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dirs = {-1, 0, 1};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = 0;

                for (int dr : dirs) {
                    for (int dc : dirs) {
                        if (dr == 0 && dc == 0) continue;
                        int nr = r + dr, nc = c + dc;
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] & 1) == 1) {
                            liveNeighbors++;
                        }
                    }
                }
                if ((board[r][c] & 1) == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[r][c] |= 2; 
                }
                if ((board[r][c] & 1) == 0 && liveNeighbors == 3) {
                    board[r][c] |= 2; 
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] >>= 1;
            }
        }
    }
}