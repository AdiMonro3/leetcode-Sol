// Last updated: 06/08/2026, 19:53:59
1class Solution {
2    public int smallestNumber(int n, int t) {
3        while (true) {
4            if (digitProduct(n) % t == 0) {
5                return n;
6            }
7            n++;
8        }
9    }
10
11    private int digitProduct(int num) {
12        int product = 1;
13
14        while (num > 0) {
15            product *= (num % 10);
16            num /= 10;
17        }
18
19        return product;
20    }
21}