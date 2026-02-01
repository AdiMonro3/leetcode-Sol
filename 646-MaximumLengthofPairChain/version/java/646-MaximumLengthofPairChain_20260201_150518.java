// Last updated: 01/02/2026, 15:05:18
1class Solution {
2    int n;
3    int dp[][];
4    public int helper(int[][] pairs,int i,int prev){
5        if(i>=n) return 0;
6        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];
7
8        int pick=0;
9        if(prev==-1 || pairs[i][0]>pairs[prev][1]){
10            pick=1+helper(pairs,i+1,i);
11        }
12        int notpick=helper(pairs,i+1,prev);
13
14        if(prev!=-1){
15            dp[i][prev]=Math.max(pick,notpick);
16        }
17        return Math.max(pick,notpick);
18    }
19    public int findLongestChain(int[][] pairs) {
20        n=pairs.length;
21        dp=new int[1000][1000];
22        for(int i=0;i<1000;i++){
23            Arrays.fill(dp[i],-1);
24        }
25        Arrays.sort(pairs,(a, b) -> a[1] - b[1]);
26        return helper(pairs,0,-1);
27    }
28}