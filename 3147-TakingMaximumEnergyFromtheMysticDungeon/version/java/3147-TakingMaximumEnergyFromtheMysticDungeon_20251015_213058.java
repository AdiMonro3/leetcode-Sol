// Last updated: 15/10/2025, 21:30:58
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i];
            if (i + k < n) dp[i] += dp[i + k];
        }
        int ans = Integer.MIN_VALUE;
        for (int x : dp) ans = Math.max(ans, x);
        return ans;
    }
}

    