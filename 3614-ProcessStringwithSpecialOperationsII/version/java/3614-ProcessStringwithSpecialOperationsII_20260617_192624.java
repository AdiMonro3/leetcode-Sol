// Last updated: 17/06/2026, 19:26:24
1class Solution {
2    public char processStr(String s, long k) {
3        int n = s.length();
4
5        long L = 0;
6
7        for (int i = 0; i < n; i++) {
8            char ch = s.charAt(i);
9            if (ch == '*') {
10                if (L > 0)
11                    L--;
12            } else if (ch == '#') {
13                L *= 2;
14            } else if (ch == '%') {
15                // reverse - no change in L
16                continue;
17            } else { // 'a' to 'z'
18                L++;
19            }
20        }
21
22        if (k >= L) {
23            return '.';
24        }
25
26        for (int i = n - 1; i >= 0; i--) {
27            char ch = s.charAt(i);
28            if (ch == '*') {
29                L++; // no change in k
30            } else if (ch == '%') {
31                // no change in L
32                k = L - k - 1;
33            } else if (ch == '#') {
34                L = L / 2;
35                k = (k >= L) ? k - L : k;
36            } else { // 'a' to 'z'
37                L--;
38            }
39
40            if (k == L) {
41                return ch;
42            }
43        }
44
45        return '.';
46    }
47}