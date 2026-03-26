// Last updated: 26/03/2026, 11:40:36
1import java.util.*;
2
3class Solution {
4    int n;
5    int[][] t = new int[1001][1003];
6
7    public int solve(int[] nums, int i, int diff) {
8        if (i < 0)
9            return 0;
10
11        if (t[i][diff + 501] != -1)
12            return t[i][diff + 501];
13
14        int ans = 0;
15
16        for (int k = i - 1; k >= 0; k--) {
17            if (nums[i] - nums[k] == diff) {
18                ans = Math.max(ans, 1 + solve(nums, k, diff));
19            }
20        }
21
22        return t[i][diff + 501] = ans;
23    }
24
25    public int longestArithSeqLength(int[] nums) {
26        n = nums.length;
27
28        if (n <= 2)
29            return n;
30
31        // Initialize DP with -1
32        for (int[] row : t) {
33            Arrays.fill(row, -1);
34        }
35
36        int result = 0;
37
38        for (int i = 0; i < n; i++) {
39            for (int j = i + 1; j < n; j++) {
40                result = Math.max(result,
41                        2 + solve(nums, i, nums[j] - nums[i]));
42            }
43        }
44
45        return result;
46    }
47} 