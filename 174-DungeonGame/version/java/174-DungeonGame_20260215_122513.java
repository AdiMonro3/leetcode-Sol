// Last updated: 15/02/2026, 12:25:13
1class Solution {
2    int n;
3    int m;
4    int[][]dp;
5    public int helper(int[][] mat,int i,int j){
6        if(i<0 || i>=n || j<0 || j>=m) return Integer.MAX_VALUE;
7        if(i==n-1 && j==m-1){
8            if(mat[i][j]<0){
9                return 1-mat[i][j];
10            }
11
12            return 1;
13        }
14
15        if(dp[i][j]!=-1) return dp[i][j];
16
17        int right=helper(mat,i,j+1);
18        int down=helper(mat,i+1,j);
19
20        return dp[i][j]=Math.max(1,Math.min(right,down)-mat[i][j]);
21    }
22    public int calculateMinimumHP(int[][] dungeon) {
23        n=dungeon.length;
24        m=dungeon[0].length;
25        dp=new int[n][m];
26
27        for(int i=0;i<n;i++){
28            Arrays.fill(dp[i],-1);
29        }
30        return helper(dungeon,0,0);
31    }
32}