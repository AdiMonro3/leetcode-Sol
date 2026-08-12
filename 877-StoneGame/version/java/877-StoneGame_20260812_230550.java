// Last updated: 12/08/2026, 23:05:50
1class Solution {
2    
3    public boolean stoneGame(int[] piles) {
4         int n = piles.length;
5    int[][] dp = new int[n][n];
6    for (int i = 0; i < n; i++) dp[i][i] = piles[i];
7    for (int len = 2; len <= n; len++)
8        for (int i = 0; i + len - 1 < n; i++) {
9            int j = i + len - 1;
10            dp[i][j] = Math.max(piles[i] - dp[i + 1][j],
11                                piles[j] - dp[i][j - 1]);
12        }
13    return dp[0][n - 1] > 0;
14        
15    }
16}