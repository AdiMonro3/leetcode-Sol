// Last updated: 23/01/2026, 17:36:23
1class Solution {
2    public int maxDistToClosest(int[] seats) {
3        int n = seats.length;
4        int[] left = new int[n];
5
6        int last = -1;
7        for (int i = 0; i < n; i++) {
8            if (seats[i] == 1) last = i;
9                left[i] = (last == -1) ? Integer.MAX_VALUE : i - last;
10        }
11        int max = 0;
12        last = -1;
13
14        for (int i = n - 1; i >= 0; i--) {
15            if (seats[i] == 1) last = i;
16
17            int rightDist = (last == -1) ? Integer.MAX_VALUE : last - i;
18            int dist = Math.min(left[i], rightDist);
19
20            if (seats[i] == 0)
21                max = Math.max(max, dist);
22        }
23        return max;
24    }
25}