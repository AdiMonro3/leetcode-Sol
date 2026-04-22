// Last updated: 22/04/2026, 19:14:35
1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        int n = nums.length;
4        int[] freq = new int[n + 1];
5
6        for (int num : nums) {
7            freq[num]++;
8        }
9
10        int duplicate = -1, missing = -1;
11
12        for (int i = 1; i <= n; i++) {
13            if (freq[i] == 2) duplicate = i;
14            if (freq[i] == 0) missing = i;
15        }
16
17        return new int[]{duplicate, missing};
18    }
19}