// Last updated: 28/05/2026, 23:20:33
1class Solution {
2    static final long B1 = 131, M1 = 1_000_000_007L;
3    static final long B2 = 137, M2 = 998_244_353L;
4
5    private long[][] buildPow(int n) {
6        long[][] pow = new long[2][n + 1];
7        pow[0][0] = pow[1][0] = 1;
8        for (int i = 1; i <= n; i++) {
9            pow[0][i] = pow[0][i-1] * B1 % M1;
10            pow[1][i] = pow[1][i-1] * B2 % M2;
11        }
12        return pow;
13    }
14
15    private boolean hasUnique(int[] nums, int L, long[][] pow) {
16        int n = nums.length;
17
18        // First window — dono hash
19        long h1 = 0, h2 = 0;
20        for (int i = 0; i < L; i++) {
21            h1 = (h1 * B1 + nums[i]) % M1;
22            h2 = (h2 * B2 + nums[i]) % M2;
23        }
24
25        HashMap<Long, Integer> freq = new HashMap<>();
26        freq.merge(h1 * 1_000_000_009L + h2, 1, Integer::sum);
27
28        // Roll
29        for (int i = 0; i < n - L; i++) {
30            h1 = (h1 - nums[i] * pow[0][L-1] % M1 + M1) % M1;
31            h1 = (h1 * B1 + nums[i + L]) % M1;
32
33            h2 = (h2 - nums[i] * pow[1][L-1] % M2 + M2) % M2;
34            h2 = (h2 * B2 + nums[i + L]) % M2;
35
36            freq.merge(h1 * 1_000_000_009L + h2, 1, Integer::sum);
37        }
38
39        for (int cnt : freq.values())
40            if (cnt == 1) return true;
41
42        return false;
43    }
44
45    public int smallestUniqueSubarray(int[] nums) {
46        int n = nums.length;
47        long[][] pow = buildPow(n);
48
49        int lo = 1, hi = n, ans = n;
50        while (lo <= hi) {
51            int mid = (lo + hi) / 2;
52            if (hasUnique(nums, mid, pow)) {
53                ans = mid;
54                hi = mid - 1;
55            } else {
56                lo = mid + 1;
57            }
58        }
59        return ans;
60    }
61}