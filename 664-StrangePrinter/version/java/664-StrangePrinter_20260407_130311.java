// Last updated: 07/04/2026, 13:03:11
1class Solution {
2    int n;
3    int dp[][];
4    public int helper(String s,int i,int j){
5        if(i==n) return 0;
6        if(i>j) return 0;
7        if(i==j) return 1;
8
9        if(dp[i][j]!=-1) return dp[i][j];
10
11        int min=1+helper(s,i+1,j);
12
13        for(int k=i+1;k<=j;k++){
14            if(s.charAt(i)==s.charAt(k)){
15                min=Math.min(min,helper(s,i+1,k-1)+helper(s,k,j));
16            }
17        }
18        return dp[i][j]=min;
19    }
20    public int strangePrinter(String s) {
21        n=s.length();
22        dp=new int[n][n];
23        for(int i=0;i<n;i++){
24            Arrays.fill(dp[i],-1);
25        }
26        return helper(s,0,n-1);
27    }
28}