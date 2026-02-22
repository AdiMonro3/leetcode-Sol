// Last updated: 22/02/2026, 06:56:54
1class Solution {
2    int m, n, K;
3    int[][][] t;
4    final int INF = (int)1e9;
5
6    private int solve(int i, int j, int tPort, int[][] grid) {
7        if (i == m - 1 && j == n - 1)
8            return 0;
9
10        if (t[i][j][tPort] != -1)
11            return t[i][j][tPort];
12
13        int result = INF;
14        int curVal = grid[i][j];
15
16        // Move Right
17        if (j + 1 < n) {
18            int next = solve(i, j + 1, tPort, grid);
19            result = Math.min(result, grid[i][j + 1] + next);
20        }
21
22        // Move Down
23        if (i + 1 < m) {
24            int next = solve(i + 1, j, tPort, grid);
25            result = Math.min(result, grid[i + 1][j] + next);
26        }
27
28        // Teleport
29        if (tPort < K) {
30            for (int x = 0; x < m; x++) {
31                for (int y = 0; y < n; y++) {
32                    if ((x != i || y != j) && grid[x][y] <= curVal) {
33                        result = Math.min(result, solve(x, y, tPort + 1, grid));
34                    }
35                }
36            }
37        }
38
39        return t[i][j][tPort] = result;
40    }
41
42    public int minCost(int[][] grid, int k) {
43        m = grid.length;
44        n = grid[0].length;
45        K = k;
46
47        // t = new int[m][n][K + 1];
48        // for (int i = 0; i < m; i++)
49        //     for (int j = 0; j < n; j++)
50        //         for (int tp = 0; tp <= K; tp++)
51        //             t[i][j][tp] = -1;
52
53        // return solve(0, 0, 0, grid);
54        int dp[][]=new int[m][n];
55        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
56        dp[m-1][n-1]=0;
57
58        int maxVal = 0;
59        for (int[] row : grid) {
60            for (int val : row) {
61                maxVal = Math.max(maxVal, val);
62            }
63        }
64
65        int[] teleportCost = new int[maxVal + 1];
66        Arrays.fill(teleportCost, Integer.MAX_VALUE);
67
68        for(int t=0;t<=k;t++){
69            // fill dp table
70            for(int i=m-1;i>=0;i--){
71
72                for(int j=n-1;j>=0;j--){
73                    
74                     if (i + 1 < m && dp[i + 1][j] != Integer.MAX_VALUE) {
75                        dp[i][j] = Math.min(dp[i][j], grid[i + 1][j] + dp[i + 1][j]);
76                    }
77
78                    if (j + 1 < n && dp[i][j + 1] != Integer.MAX_VALUE) {
79                        dp[i][j] = Math.min(dp[i][j], grid[i][j + 1] + dp[i][j + 1]);
80                    }
81
82                    if (t > 0) {
83                        dp[i][j] = Math.min(dp[i][j], teleportCost[grid[i][j]]);
84                    }
85                }
86            }
87            // Update teleport cost using current dp
88            for (int i = 0; i < m; i++) {
89                for (int j = 0; j < n; j++) {
90                    int val = grid[i][j];
91                    teleportCost[val] = Math.min(teleportCost[val], dp[i][j]);
92                }
93            }
94            for (int v = 1; v <= maxVal; v++) {
95                teleportCost[v] = Math.min(teleportCost[v], teleportCost[v - 1]);
96            }
97        }
98
99        return dp[0][0];
100    }
101}