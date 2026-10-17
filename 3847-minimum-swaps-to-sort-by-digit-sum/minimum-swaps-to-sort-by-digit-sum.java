import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int val = nums[i], sum = 0;
            while (val > 0) {
                sum += val % 10;
                val /= 10;
            }
            arr[i][0] = sum;
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        boolean[] vis = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || arr[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            while (!vis[curr]) {
                vis[curr] = true;
                curr = arr[curr][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}