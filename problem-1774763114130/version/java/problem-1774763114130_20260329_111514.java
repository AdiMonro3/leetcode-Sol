// Last updated: 29/03/2026, 11:15:14
1class Solution {
2    public int minCost(int[][] grid) {
3        int m=grid.length;
4        int n=grid[0].length;
5
6        Set<Integer>[][] dp=new HashSet[m][n];
7
8        for(int i=0;i<m;i++){
9            for(int j=0;j<n;j++){
10                dp[i][j]=new HashSet<>();
11                
12                if(i==0 && j==0){
13                    dp[i][j].add(grid[i][j]);
14                    continue;
15                }
16            
17
18                if(i>0){
19                    for(int val:dp[i-1][j]){
20                        dp[i][j].add(val^grid[i][j]);
21                    }
22                }
23    
24                if(j>0){
25                    for(int val:dp[i][j-1]){
26                        dp[i][j].add(val^grid[i][j]);
27                    }
28                }
29            }
30        }
31
32        int ans=Integer.MAX_VALUE;
33
34        for(int val:dp[m-1][n-1]){
35            ans=Math.min(ans,val);
36        }
37
38        return ans;
39    }
40}