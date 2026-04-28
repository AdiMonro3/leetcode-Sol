// Last updated: 28/04/2026, 19:28:10
1class Solution {
2    public int mirrorDistance(int n) {
3        int original = n;
4        int reversed = 0;
5
6        while (n > 0) {
7            int digit = n % 10;
8            reversed = reversed * 10 + digit;
9            n /= 10;
10        }
11
12        return Math.abs(original - reversed);
13    }
14}