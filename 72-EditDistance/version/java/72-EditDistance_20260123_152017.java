// Last updated: 23/01/2026, 15:20:17
1class Solution {
2    int n;
3    int m;
4    int[][] dp;
5    public int helper(String s,String t,int i,int j){
6        if(j>=m){
7            if(i<n) return n-i;
8            else return 0;
9        }
10        if(i>=n && j<m) return m-j;
11
12        if(dp[i][j]!=-1) return dp[i][j];
13        
14        if(s.charAt(i)==t.charAt(j)){
15            return dp[i][j]=helper(s,t,i+1,j+1);
16        }else{
17            int insert=1+helper(s,t,i,j+1);
18            int delete=1+helper(s,t,i+1,j);
19            int replace=1+helper(s,t,i+1,j+1);
20
21            dp[i][j]=Math.min(insert,Math.min(replace,delete));
22        }
23        return dp[i][j];
24    }
25    public int minDistance(String word1, String word2) {
26        n=word1.length();
27        m=word2.length();
28        dp=new int[n][m];
29        for(int i=0;i<n;i++){
30            for(int j=0;j<m;j++){
31                dp[i][j]=-1;
32            }
33        }
34        return helper(word1,word2,0,0);
35
36
37    }
38}