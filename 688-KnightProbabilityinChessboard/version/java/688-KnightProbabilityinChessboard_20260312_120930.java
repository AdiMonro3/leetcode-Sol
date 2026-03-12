// Last updated: 12/03/2026, 12:09:30
1class Solution {
2    int dir[][]={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
3    double dp[][][];
4    public double helper(int n,int k,int i,int j){
5        if(i<0 ||j<0 || i>=n || j>=n) return 0;
6        if(k==0) return 1;
7
8        if(dp[i][j][k]!=-1) return dp[i][j][k];
9
10        double prob=0;
11
12        for(int d=0;d<8;d++){
13
14            int newr=i+dir[d][0];
15            int newc=j+dir[d][1];
16
17            prob+=helper(n,k-1,newr,newc);
18        }
19
20        return dp[i][j][k]=prob/8;
21    }
22
23    public double knightProbability(int n, int k, int row, int col) {
24
25        dp=new double[n][n][k+1];
26        for(int i=0;i<n;i++){
27            for(int j=0;j<n;j++){
28                Arrays.fill(dp[i][j],-1);
29            }
30        }
31        
32        return helper(n,k,row,col);
33    }
34}