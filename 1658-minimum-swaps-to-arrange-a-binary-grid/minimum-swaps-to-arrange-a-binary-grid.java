class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, ans = 0;
        int[] zeros = new int[n];

        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j >= 0 && grid[i][j] == 0) j--;
            zeros[i] = n - 1 - j;
        }
        for (int i = 0; i < n; i++) {
            int need = n - 1 - i, j = i;
            while (j < n && zeros[j] < need) j++;
            if (j == n) return -1;
            while (j > i) {
                int tmp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = tmp;
                j--; ans++;
            }
        }
        return ans;
    }
}
