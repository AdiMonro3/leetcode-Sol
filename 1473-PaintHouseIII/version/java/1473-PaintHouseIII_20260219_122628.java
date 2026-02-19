// Last updated: 19/02/2026, 12:26:28
1class Solution {
2    long INF=Long.MAX_VALUE;
3    long dp[][][];
4    public long helper(int n,int[][] cost,int i,int prev,int next){
5        if(i>=n/2) return 0;
6        if(prev!=-1 && next!=-1 && dp[i][prev][next]!=-1) return dp[i][prev][next];
7
8        long min=INF;
9        for(int k=0;k<cost[0].length;k++){
10            for(int l=0;l<cost[0].length;l++){
11                if(k==l) continue;
12                if(prev==k || next==l) continue;
13                int equiDist=n-(i+1);
14                long paint=helper(n,cost,i+1,k,l);
15                if(paint!=INF){
16                    min=Math.min(min,cost[i][k]+cost[equiDist][l]+paint);
17                }
18            }
19        }
20        if(prev!=-1 && next!=-1) dp[i][prev][next]=min;
21        return min;
22    }
23    public long minCost(int n, int[][] cost) {
24        int m=n/2;
25        m=m+1;
26        dp=new long[m][3][3];
27        for(int i=0;i<m;i++){
28            for(int j=0;j<3;j++){
29                Arrays.fill(dp[i][j],-1);
30            }
31        }
32
33        return helper(n,cost,0,-1,-1);
34    }
35}