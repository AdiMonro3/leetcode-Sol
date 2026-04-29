// Last updated: 30/04/2026, 02:40:10
1class Solution {
2    int n, m;
3    int[][][] dp;
4
5    public int helper(int[][] grid, int i, int j, int bullets) {
6        if (i >= n || j >= m) return Integer.MIN_VALUE;
7
8        // Last cell
9        if (i == n - 1 && j == m - 1) {
10            if (grid[i][j] < 0 && bullets > 0) return 0;
11            return grid[i][j];
12        }
13
14        if (dp[i][j][bullets] != Integer.MIN_VALUE) return dp[i][j][bullets];
15
16        int right = Integer.MIN_VALUE;
17        int down = Integer.MIN_VALUE;
18
19        if (grid[i][j] >= 0) {
20            right = grid[i][j] + helper(grid, i, j + 1, bullets);
21            down = grid[i][j] + helper(grid, i + 1, j, bullets);
22        } else {
23            // Option 1: take negative
24            int take = grid[i][j] + Math.max(
25                helper(grid, i, j + 1, bullets),
26                helper(grid, i + 1, j, bullets)
27            );
28
29            // Option 2: skip using bullet
30            int skip = Integer.MIN_VALUE;
31            if (bullets > 0) {
32                skip = Math.max(
33                    helper(grid, i, j + 1, bullets - 1),
34                    helper(grid, i + 1, j, bullets - 1)
35                );
36            }
37
38            return dp[i][j][bullets] = Math.max(take, skip);
39        }
40
41        return dp[i][j][bullets] = Math.max(right, down);
42    }
43
44    public int maximumAmount(int[][] coins) {
45        n = coins.length;
46        m = coins[0].length;
47        
48        dp = new int[n][m][3]; // assuming max bullets = 2
49        for(int i=0;i<n;i++){
50            for(int j=0;j<m;j++){
51                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
52            }
53        }
54
55        return helper(coins, 0, 0, 2);
56    }
57}