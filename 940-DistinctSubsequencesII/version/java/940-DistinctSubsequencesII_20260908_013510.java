// Last updated: 08/09/2026, 01:35:10
1class Solution {
2    public int distinctSubseqII(String s) {
3        int n = s.length();
4        int MOD = 1_000_000_007; // equivalent to 1e9 + 7
5        int[] w = new int[26];
6        int sum = 0;
7
8        for (int i = 0; i < n; i++) {
9            int idx = s.charAt(i) - 'a';
10            
11            // + MOD ensures the result is strictly positive before modulo in Java
12            int cur = (1 + sum - w[idx] + MOD) % MOD;
13            
14            sum = (sum + cur) % MOD;
15            w[idx] = (w[idx] + cur) % MOD;
16        }
17
18        return sum;
19    }
20}