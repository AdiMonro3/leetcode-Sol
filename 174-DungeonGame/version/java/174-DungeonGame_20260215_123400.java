// Last updated: 15/02/2026, 12:34:00
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
22    public int tabulation(int[][] mat,int n,int m){
23        int[][] dp=new int[n][m];
24        dp[n-1][m-1]=Math.max(1,1-mat[n-1][m-1]);
25
26        for(int i=n-1;i>=0;i--){
27            for(int j=m-1;j>=0;j--){
28                if(i==n-1 && j==m-1) continue;
29
30                int right=(j+1<m)?dp[i][j+1]:Integer.MAX_VALUE;
31                int down =(i+1<n)?dp[i+1][j]:Integer.MAX_VALUE;
32
33                dp[i][j]=Math.max(1,Math.min(right,down)-mat[i][j]);
34
35            }
36        }
37        return dp[0][0];
38    }
39    public int calculateMinimumHP(int[][] dungeon) {
40        n=dungeon.length;
41        m=dungeon[0].length;
42        dp=new int[n][m];
43
44        for(int i=0;i<n;i++){
45            Arrays.fill(dp[i],-1);
46        }
47        // return helper(dungeon,0,0);
48        return tabulation(dungeon,n,m);
49    }
50}