// Last updated: 18/02/2026, 15:53:08
1class Solution {
2    int n;
3    int m;
4    int[][][] dp;
5    public int helper(int[] houses,int[][] cost,int i,int target,int prev){
6        if(i>=m){
7            if(target==0) return 0;
8            else return Integer.MAX_VALUE;
9        }
10        if(target<0) return Integer.MAX_VALUE;
11
12        if (dp[i][prev][target] != -1) return dp[i][prev][target];
13
14        int min=Integer.MAX_VALUE;
15
16        if (houses[i] != 0) {
17            int newTarget = target - (houses[i] != prev ? 1 : 0);
18            min = helper(houses, cost, i + 1,newTarget, houses[i]);
19        }
20        // Not painted
21        else {
22            for (int color = 1; color <= n; color++) {
23
24                int newTarget = target - (color != prev ? 1 : 0);
25
26                int next =  helper(houses, cost, i + 1,newTarget,color);
27
28                if (next != Integer.MAX_VALUE) {
29                    min= Math.min(min,cost[i][color - 1]+next);
30                }
31            }
32        }
33        return dp[i][prev][target] = min;
34    }
35    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
36        this.n=n;
37        this.m=m;
38        dp = new int[m][n + 1][target + 1];
39
40        for (int i = 0; i < m; i++) {
41            for (int j = 0; j <= n; j++) {
42                Arrays.fill(dp[i][j], -1);
43            }
44        }
45
46        int ans = helper(houses, cost, 0,target,0);
47
48        return ans == Integer.MAX_VALUE ? -1 : ans;
49    }
50}