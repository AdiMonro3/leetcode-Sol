// Last updated: 09/03/2026, 15:09:37
1class Solution {
2    int row[]={-1,0,1,0};
3    int col[]={0,1,0,-1};
4    int dp[][][];
5    int MOD=1000000000+7;
6    public int helper(int n,int m,int maxMove,int i,int j){
7        if(i<0 || j<0 || i>=n || j>=m) return 1;
8
9        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
10        
11        int temp=0;
12        for(int d=0;d<4;d++){
13            int newr=i+row[d];
14            int newc=j+col[d];
15
16            if(maxMove>0){
17                temp=(temp+helper(n,m,maxMove-1,newr,newc)) % MOD;
18            }
19        }
20        return dp[i][j][maxMove]=temp;
21    }
22    public int findPaths(int n, int m, int maxMove, int i, int j) {
23        dp=new int[n][m][maxMove+1];
24        for(int r=0;r<n;r++){
25            for(int c=0;c<m;c++){
26                Arrays.fill(dp[r][c],-1);
27            }
28        }
29
30        return helper(n,m,maxMove,i,j);
31
32
33    }
34}