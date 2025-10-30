// Last updated: 30/10/2025, 19:26:14
class Solution {
    Integer[][] dp = new Integer[1005][1005];
    int MOD = 1_000_000_007;

    int countTilingWays(int r1, int r2) {
        if (r1 == 0 && r2 == 0) return 1;
        if (r1 < 0 || r2 < 0) return 0;
        if (dp[r1][r2] != null) return dp[r1][r2];

        long count = 0;
        if (r1 == r2) {
            count += countTilingWays(r1 - 2, r2 - 2); // Horizontal tile both
            count += countTilingWays(r1 - 1, r2 - 1); // Vertical tile
            count += countTilingWays(r1 - 2, r2 - 1); // Inverted L
            count += countTilingWays(r1 - 1, r2 - 2); // Mirror L
        } else if (r1 > r2) {
            count += countTilingWays(r1 - 2, r2);     // Horizontal tile row-1
            count += countTilingWays(r1 - 2, r2 - 1); // Inverted L Mirror
        } else {
            count += countTilingWays(r1, r2 - 2);     // Horizontal tile row-2
            count += countTilingWays(r1 - 1, r2 - 2); // L shape
        }

        return dp[r1][r2] = (int)(count % MOD);
    }

    public int numTilings(int n) {
         return countTilingWays(n, n);
    }
}