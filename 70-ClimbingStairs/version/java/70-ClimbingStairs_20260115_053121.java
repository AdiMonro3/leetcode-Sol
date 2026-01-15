// Last updated: 15/01/2026, 05:31:21
1class Solution {
2    int dp[];
3    public int climb(int n){
4        if(n==0 || n==1) return 1;
5        if(dp[n]!=-1) return dp[n];
6        int ways=climb(n-1)+climb(n-2);
7        return dp[n]=ways;
8    }
9    public int climbStairs(int n) {
10        dp=new int[n+1];
11        for(int i=0;i<=n;i++){
12            dp[i]=-1;
13        }
14        int ans=climb(n);
15        return ans;
16
17    }
18}