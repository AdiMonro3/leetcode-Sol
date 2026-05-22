// Last updated: 22/05/2026, 22:39:49
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n = cost.length;
4        
5        int[] dp = new int[n];
6        dp[0] = cost[0];
7        dp[1] = cost[1];
8        
9        for (int i = 2; i < n; i++) {
10            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
11        }
12        
13        return Math.min(dp[n-1], dp[n-2]);
14    }
15}