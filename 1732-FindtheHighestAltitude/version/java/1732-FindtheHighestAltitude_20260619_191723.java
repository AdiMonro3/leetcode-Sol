// Last updated: 19/06/2026, 19:17:23
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int altitude = 0;
4        int maxAltitude = 0;
5
6        for (int g : gain) {
7            altitude += g;
8            maxAltitude = Math.max(maxAltitude, altitude);
9        }
10
11        return maxAltitude;
12    }
13}