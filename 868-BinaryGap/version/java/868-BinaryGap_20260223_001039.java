// Last updated: 23/02/2026, 00:10:39
1class Solution {
2    public int binaryGap(int n) {
3        int prev = -1;      // previous 1 position
4        int index = 0;      // current bit index
5        int maxDist = 0;
6
7        while (n > 0) {
8
9            if ((n & 1) == 1) {   // if last bit is 1
10                if (prev != -1) {
11                    maxDist = Math.max(maxDist, index - prev);
12                }
13                prev = index;
14            }
15
16            n >>= 1;   // shift right
17            index++;
18        }
19
20        return maxDist;
21    }
22}