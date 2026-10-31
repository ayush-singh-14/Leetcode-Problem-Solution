class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] target = new int[m][n][2];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) continue;
                target[r][c][0] = resolve(grid, m, n, r, c + 1, 0);
                target[r][c][1] = resolve(grid, m, n, r + 1, c, 1);
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0 || grid[r][c] == 1) continue;

                long ways = dp[r][c];

                int destRight = target[r][c][0];
                if (destRight != -1) {
                    int nr = destRight / n;
                    int nc = destRight % n;
                    dp[nr][nc] = (int) ((dp[nr][nc] + ways) % MOD);
                }
                int destDown = target[r][c][1];
                if (destDown != -1) {
                    int nr = destDown / n;
                    int nc = destDown % n;
                    dp[nr][nc] = (int) ((dp[nr][nc] + ways) % MOD);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
    private int resolve(int[][] grid, int m, int n, int r, int c, int dir) {
        int currR = r;
        int currC = c;
        int currDir = dir;

        while (currR >= 0 && currR < m && currC >= 0 && currC < n) {
            if (grid[currR][currC] == 0) {
                return currR * n + currC;
            }
            if (currDir == 0) {
                currDir = 1;
                currR++;
            } else {
                currDir = 0;
                currC++;
            }
        }

        return -1;
    }
}