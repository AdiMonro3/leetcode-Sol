// Last updated: 09/02/2026, 21:45:17
1class Solution {
2    public int[] countOfPairs(int n, int x, int y) {
3        int[] ans = new int[n];
4
5        for (int i = 1; i <= n; i++) {
6            for (int j = i + 1; j <= n; j++) {
7
8                int d1 = Math.abs(i - j);
9                int d2 = Math.abs(i - x) + 1 + Math.abs(y - j);
10                int d3 = Math.abs(i - y) + 1 + Math.abs(x - j);
11
12                int d = Math.min(d1, Math.min(d2, d3));
13
14                ans[d - 1] += 2;
15            }
16        }
17
18        return ans;
19    }
20}
21