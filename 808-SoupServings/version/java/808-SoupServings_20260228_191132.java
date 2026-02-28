// Last updated: 28/02/2026, 19:11:32
1class Solution {
2    List<int[]> serves = Arrays.asList(
3        new int[]{4, 0},
4        new int[]{3, 1},
5        new int[]{2, 2},
6        new int[]{1, 3}
7    );
8
9    double[][] dp;
10
11    public double helper(int A, int B) {
12
13        if (A <= 0 && B <= 0) return 0.5;
14        if (A <= 0) return 1.0;
15        if (B <= 0) return 0.0;
16
17        if (dp[A][B] != -1) return dp[A][B];
18
19        double prob = 0.0;
20
21        for (int[] s : serves) {
22            prob += 0.25 * helper(A - s[0], B - s[1]);
23        }
24
25        return dp[A][B] = prob;
26    }
27
28    public double soupServings(int n) {
29
30        if (n >= 5000) return 1.0;
31
32        int N = (n + 24) / 25;   // scale down
33
34        dp = new double[N + 1][N + 1];
35
36        for (int i = 0; i <= N; i++) {
37            Arrays.fill(dp[i], -1);
38        }
39
40        return helper(N, N);
41    }
42}