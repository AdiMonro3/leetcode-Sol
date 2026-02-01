// Last updated: 01/02/2026, 16:09:47
1class Solution {
2    int n;
3    int[][] dp;
4    public boolean isSafe(String s,String t){
5        if (t.length() != s.length() + 1) return false;
6
7    int i = 0, j = 0;
8    boolean skipped = false;
9
10    while (i < s.length() && j < t.length()) {
11        if (s.charAt(i) == t.charAt(j)) {
12            i++;
13            j++;
14        } else {
15            if (skipped) return false;
16            skipped = true;
17            j++; // skip inserted char
18        }
19    }
20
21    return true;
22    }
23    public int LIS(String[] words,int i,int prev){
24        if(i>=n) return 0;
25
26        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];
27
28        int pick=0;
29        if(prev==-1 || isSafe(words[prev],words[i])){
30            pick=1+LIS(words,i+1,i);
31        }
32        int notpick=LIS(words,i+1,prev);
33
34        if(prev!=-1){
35            dp[i][prev]=Math.max(pick,notpick);
36        }
37
38        return Math.max(pick,notpick);
39    }
40    public int longestStrChain(String[] words) {
41        Arrays.sort(words,(a,b)->a.length()-b.length());
42        n=words.length;
43         dp = new int[1001][1001];
44
45        for (int[] row : dp)
46            Arrays.fill(row, -1);
47         return LIS(words, 0, -1);
48    }
49}