// Last updated: 14/08/2026, 00:29:22
1class Solution {
2    int[] prefixSum;
3    int[][] dp;
4    public int helper(int[] piles, int i,int m){
5        if(i>=piles.length) return 0;
6
7        if (dp[i][m] != -1) {
8            return dp[i][m];
9        }
10
11        int totalRemaining = prefixSum[piles.length - 1];
12
13        if (i > 0) {
14            totalRemaining -= prefixSum[i - 1];
15        }
16
17
18        int maxAlice=0;
19        for(int j=i;j < i + 2*m && j < piles.length;j++){
20            if(j>=piles.length) break;
21            int alice_sum;
22            if(i==0){
23                alice_sum=prefixSum[j];
24            }else{
25                alice_sum=prefixSum[j]-prefixSum[i-1];
26            }
27
28            int temp=helper(piles,j+1,Math.max(m,(j - i + 1)));
29            int alice = totalRemaining - temp;
30
31            maxAlice=Math.max(alice,maxAlice);
32        }
33        return dp[i][m] = maxAlice;
34    }
35    public int stoneGameII(int[] piles) {
36        int n=piles.length;
37        prefixSum=new int[n];
38        prefixSum[0]=piles[0];
39
40        for(int i=1;i<n;i++){
41            prefixSum[i]=piles[i]+prefixSum[i-1];
42        }
43        dp = new int[n][n + 1];
44
45        for (int i = 0; i < n; i++) {
46            Arrays.fill(dp[i], -1);
47        }
48
49        int result=helper(piles,0,1);
50        return result;
51    }
52}