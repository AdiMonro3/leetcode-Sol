// Last updated: 13/10/2025, 17:47:25
class Solution {
    public int helper(int n, int[] dp) {
        // Base Case
        if (n == 0) return 0; // 0 needs 0 squares
        if (dp[n] != -1) return dp[n]; // memoized result

        int min = Integer.MAX_VALUE;

        // try every square number less than or equal to n
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            int curr = 1 + helper(n - square, dp);
            min = Math.min(min, curr);
        }

        return dp[n] = min; // store and return
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}