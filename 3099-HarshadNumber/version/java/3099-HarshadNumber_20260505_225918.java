// Last updated: 05/05/2026, 22:59:18
1class Solution {
2    public int sumOfTheDigitsOfHarshadNumber(int x) {
3        int sum = 0;
4        int temp = x;
5
6        while (temp > 0) {
7            sum += temp % 10;
8            temp /= 10;
9        }
10
11        if (x % sum == 0) {
12            return sum;
13        } else {
14            return -1;
15        }
16    }
17}