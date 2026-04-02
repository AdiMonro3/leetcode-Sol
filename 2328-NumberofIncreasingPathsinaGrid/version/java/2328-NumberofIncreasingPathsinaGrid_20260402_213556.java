// Last updated: 02/04/2026, 21:35:56
1class Solution {
2    int n;
3    int m;
4    int mod=1000000000+7;
5    int[] row={-1,0,1,0};
6    int[] col={0,1,0,-1};
7
8    int[][] dp;
9    public int helper(int[][] grid,int i,int j){
10
11        if(i<0 || j<0 || i>=n || j>=m) return 0;
12        if(dp[i][j]!=-1) return dp[i][j];
13
14        int ans=1;
15
16        for(int d=0; d<4; d++){
17            int newr=i+row[d];
18            int newc=j+col[d];
19
20            if(newr>=0 && newc>=0 && newr<n && newc<m && grid[newr][newc]>grid[i][j]){
21                ans=(ans+helper(grid ,newr, newc))%mod;
22            }
23        }
24
25        return dp[i][j]=ans;
26    }
27    public int countPaths(int[][] grid) {
28        n=grid.length;
29        m=grid[0].length;
30
31        dp=new int[n][m];
32        for(int i=0;i<n;i++){
33            Arrays.fill(dp[i],-1);
34        }
35
36        int ans=0;
37        for(int i=0;i<n;i++){
38            for(int j=0;j<m;j++){
39                ans=(ans+helper(grid,i,j))%mod;
40            }
41        }
42
43        return ans;
44    }
45}