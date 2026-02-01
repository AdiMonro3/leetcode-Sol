// Last updated: 01/02/2026, 11:33:48
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        
4        int n = triangle.size();
5
6        // Copy last row as starting DP
7        int[] dp = new int[n];
8        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
9            dp[j] = triangle.get(n - 1).get(j);
10        }
11
12        // Move upwards
13        for (int i = n - 2; i >= 0; i--) {
14            for (int j = 0; j <= i; j++) {
15                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
16            }
17        }
18
19        return dp[0];
20    }
21}