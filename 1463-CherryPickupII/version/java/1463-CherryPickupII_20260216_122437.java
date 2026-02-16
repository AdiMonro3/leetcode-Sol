// Last updated: 16/02/2026, 12:24:37
1class Solution {
2    int dp[][][][];
3    int n;
4    int m;
5    public int helper(int[][] grid,int r1,int c1,int r2,int c2){
6        if(r1<0 || c1<0 ||r2<0 || c2<0 || r1>=n || r2>=n || c1>=m || c2>=m){
7            return Integer.MIN_VALUE;
8        }
9        if(r1==n-1){
10            if(c1==c2){
11                return grid[r1][c1];
12            }else{
13                return grid[r1][c1]+grid[r2][c2];
14            }
15        }
16
17        if(dp[r1][c1][r2][c2]!=-1) return dp[r1][c1][r2][c2];
18        int cherries=0;
19        if(r1==r2 && c1==c2){
20            cherries+=grid[r1][c1];
21        }else{
22            cherries+=grid[r1][c1]+grid[r2][c2];
23        }
24
25        int m1=helper(grid,r1+1,c1-1,r2+1,c2-1);
26        int m2=helper(grid,r1+1,c1-1,r2+1,c2);
27        int m3=helper(grid,r1+1,c1-1,r2+1,c2+1);
28
29        int m4=helper(grid,r1+1,c1,r2+1,c2-1);
30        int m5=helper(grid,r1+1,c1,r2+1,c2);
31        int m6=helper(grid,r1+1,c1,r2+1,c2+1);
32
33        int m7=helper(grid,r1+1,c1+1,r2+1,c2-1);
34        int m8=helper(grid,r1+1,c1+1,r2+1,c2);
35        int m9=helper(grid,r1+1,c1+1,r2+1,c2+1);
36
37        int ans = Math.max(
38            Math.max(Math.max(m1, m2), Math.max(m3, m4)),
39            Math.max(Math.max(m5, m6), Math.max(m7, Math.max(m8, m9)))
40        );
41
42        return dp[r1][c1][r2][c2]=cherries+ans;
43
44
45
46    }
47    public int cherryPickup(int[][] grid) {
48        n=grid.length;
49        m=grid[0].length;
50
51        dp=new int[n][m][n][m];
52        for(int i=0;i<n;i++){
53            for(int j=0;j<m;j++){
54                for(int k=0;k<n;k++){
55                    Arrays.fill(dp[i][j][k],-1);
56                }
57            }
58        }
59
60        return helper(grid,0,0,0,m-1);
61        
62    }
63}