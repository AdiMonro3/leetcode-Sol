// Last updated: 15/02/2026, 17:35:19
1class Solution {
2    int n, m;
3    Integer[][][][] memo;
4    public int helper(int[][] grid,int r1,int c1,int r2,int c2){
5       if(r1<0 || c1<0 || r2<0 || c2<0 || r1>=n || r2>=n || c1>=m || c2>=m || grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;
6
7        if (r1 == n - 1 && c1 == m - 1)
8            return grid[r1][c1];
9
10        if (memo[r1][c1][r2][c2] != null)
11            return memo[r1][c1][r2][c2];
12
13       int cherries=0;
14       if(r1==r2 && c1==c2){
15        cherries+=grid[r1][c1];
16       }else{
17        cherries+=grid[r1][c1]+grid[r2][c2];
18       }
19
20       // next moves
21        int m1 = helper(grid, r1 + 1, c1, r2 + 1, c2); // D, D
22        int m2 = helper(grid, r1 + 1, c1, r2, c2 + 1); // D, R
23        int m3 = helper(grid, r1, c1 + 1, r2 + 1, c2); // R, D
24        int m4 = helper(grid, r1, c1 + 1, r2, c2 + 1); // R, R
25
26        int best = Math.max(Math.max(m1, m2), Math.max(m3, m4));
27
28        cherries += best;
29
30        return memo[r1][c1][r2][c2] = cherries;
31
32    }
33    public int cherryPickup(int[][] grid) {
34         n = grid.length;
35        m = grid[0].length;
36
37        memo = new Integer[n][m][n][m];
38
39        return Math.max(0, helper(grid, 0, 0, 0, 0));
40    }
41}