// Last updated: 19/02/2026, 17:41:54
1class Solution {
2    String[] states;
3    int MOD = 1_000_000_007;
4    Integer[][] dp;
5    public boolean isSafe(int i,int j){
6        for(int k=0;k<3;k++){
7            if(states[i].charAt(k)==states[j].charAt(k)) return false;
8        }
9        return true;
10    }
11    public int helper(int n,int idx){
12        if(n==0) return 1;
13        if(dp[n][idx] != null) return dp[n][idx];
14
15        int result=0;
16        for(int i=0;i<states.length;i++){
17            if(i==idx) continue;
18            if(isSafe(i, idx)){
19                result = (result + helper(n-1, i)) % MOD;
20            }
21            
22        }
23        return dp[n][idx] = result;
24    }
25    public int numOfWays(int n) {
26        String [] str={"RYR","RYG","RGR","RGY","YRY","YRG","YGR","YGY","GRY","GRG","GYR","GYG"};
27        states=str;
28        dp = new Integer[n][states.length];
29
30        int result=0;
31        for(int i=0;i<str.length;i++){
32           result = (result + helper(n-1,i)) % MOD;
33        }
34        return result;
35
36    }
37}