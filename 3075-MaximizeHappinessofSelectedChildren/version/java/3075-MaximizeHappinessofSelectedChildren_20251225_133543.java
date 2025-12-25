// Last updated: 25/12/2025, 13:35:43
1class Solution {
2    public long maximumHappinessSum(int[] happiness, int k) {
3          Arrays.sort(happiness);
4        long ans = 0;
5        int n = happiness.length;
6
7        for (int i = 0; i < k; i++) {
8            int value = happiness[n - 1 - i] - i;
9            if (value > 0) {
10                ans += value;
11            }
12        }
13        return ans;
14    }
15}