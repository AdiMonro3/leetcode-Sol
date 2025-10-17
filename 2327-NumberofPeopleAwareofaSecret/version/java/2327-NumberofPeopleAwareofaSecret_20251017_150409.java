// Last updated: 17/10/2025, 15:04:09
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long shareable = 0;

        for (int day = 2; day <= n; day++) {
            // add people who can start sharing
            if (day - delay >= 1) {
                shareable = (shareable + dp[day - delay]) % MOD;
            }
            // remove people who forgot
            if (day - forget >= 1) {
                shareable = (shareable - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = shareable;
        }

        long ans = 0;
        // sum people who still remember
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }
}