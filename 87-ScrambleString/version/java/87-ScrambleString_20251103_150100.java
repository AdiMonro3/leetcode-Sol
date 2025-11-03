// Last updated: 03/11/2025, 15:01:00
class Solution {
    int m, n;
    int[][] apples = new int[55][55];
    long[][][] dp;
    long MOD = 1_000_000_007L;

    public long solve(int i, int j, int k) {
        if (apples[i][j] == 0) return 0;        // no apples → invalid
        if (k == 1) return 1;                   // one piece left and has apple

        if (dp[i][j][k] != -1) return dp[i][j][k];

        long ways = 0;

        // horizontal cuts
        for (int h = i + 1; h < m; ++h) {
            if (apples[i][j] - apples[h][j] > 0)
                ways = (ways + solve(h, j, k - 1)) % MOD;
        }

        // vertical cuts
        for (int v = j + 1; v < n; ++v) {
            if (apples[i][j] - apples[i][v] > 0)
                ways = (ways + solve(i, v, k - 1)) % MOD;
        }

        return dp[i][j][k] = ways;
    }

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();

        // build suffix sum
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0)
                             + (i + 1 < m ? apples[i + 1][j] : 0)
                             + (j + 1 < n ? apples[i][j + 1] : 0)
                             - (i + 1 < m && j + 1 < n ? apples[i + 1][j + 1] : 0);
            }
        }

        dp = new long[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return (int) solve(0, 0, k);
    }
}
