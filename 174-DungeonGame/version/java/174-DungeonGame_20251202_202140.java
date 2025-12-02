// Last updated: 02/12/2025, 20:21:40
1class Solution {
2    int n;
3    int m;
4    int[][] dp;
5    public int helper(int [][]dungeon,int i,int j){
6        if(i>=n || j>=m) return Integer.MAX_VALUE;
7        if(i==n-1 && j==m-1){
8            if(dungeon[i][j]<=0){
9                return Math.abs(dungeon[i][j])+1;
10            }
11            else return 1;
12        }
13        if(dp[i][j]!=-1) return dp[i][j];
14        int right=helper(dungeon,i,j+1);
15        int down=helper(dungeon,i+1,j);
16
17        return dp[i][j]=Math.max(1, Math.min(right, down) - dungeon[i][j]);
18    }
19    public int calculateMinimumHP(int[][] dungeon) {
20        n=dungeon.length;
21        m=dungeon[0].length;
22        dp=new int[n][m];
23        for(int i=0;i<n;i++){
24            for(int j=0;j<m;j++){
25                dp[i][j]=-1;
26            }
27        }
28
29        return helper(dungeon,0,0);
30    }
31}