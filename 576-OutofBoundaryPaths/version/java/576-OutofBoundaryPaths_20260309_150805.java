// Last updated: 09/03/2026, 15:08:05
1class Solution {
2    int row[]={-1,0,1,0};
3    int col[]={0,1,0,-1};
4    int dp[][][];
5    int MOD=1000000000+7;
6    public int helper(int n,int m,int maxMove,int i,int j){
7        if(maxMove == 0) return 0;
8
9        if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
10        
11        int temp=0;
12        for(int d=0;d<4;d++){
13            int newr=i+row[d];
14            int newc=j+col[d];
15
16             if(newr < 0 || newc < 0 || newr >= n || newc >= m){
17            temp = (temp + 1) % MOD;
18        }
19            else{
20            temp = (temp + helper(n,m,maxMove-1,newr,newc)) % MOD;
21        }
22        }
23        return dp[i][j][maxMove]=temp;
24    }
25    public int findPaths(int n, int m, int maxMove, int i, int j) {
26        dp=new int[n][m][maxMove+1];
27        for(int r=0;r<n;r++){
28            for(int c=0;c<m;c++){
29                Arrays.fill(dp[r][c],-1);
30            }
31        }
32
33        return helper(n,m,maxMove,i,j) % MOD;
34
35
36    }
37}