// Last updated: 27/11/2025, 17:14:01
1class Solution {
2    int MOD = 1000000007;
3   int[][][] dp;
4    public int helper(int [][] grid,int k,int n,int m,int row,int col,int sum){
5        if(col>=m || row>=n) return 0;
6        int finalsum = (sum + grid[row][col]) % k;
7        if(row==n-1 && col==m-1){
8            if(finalsum==0){
9                return 1;
10            }
11            return 0;
12        }
13        if (dp[row][col][finalsum] != -1) return dp[row][col][finalsum];
14        int right=helper(grid,k,n,m,row,col+1,(sum+grid[row][col] )%k);
15        int down=helper(grid,k,n,m,row+1,col,(sum+grid[row][col] )% k);
16
17        return dp[row][col][finalsum]=(right+down)%MOD;
18    }
19    public int numberOfPaths(int[][] grid, int k) {
20        int n=grid.length;
21        int m=grid[0].length;
22       dp = new int[n][m][k];
23        for (int i = 0; i < n; i++) {
24            for (int j = 0; j < m; j++) {
25                Arrays.fill(dp[i][j], -1);
26            }
27        }
28        return helper(grid,k,n,m,0,0,0);
29    }
30}