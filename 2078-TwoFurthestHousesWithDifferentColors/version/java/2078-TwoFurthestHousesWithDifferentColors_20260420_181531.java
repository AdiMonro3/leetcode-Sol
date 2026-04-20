// Last updated: 20/04/2026, 18:15:31
1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length;
4        int maxDist = 0;
5
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                if (colors[i] != colors[j]) {
9                    maxDist = Math.max(maxDist, j - i);
10                }
11            }
12        }
13
14        return maxDist;
15    }
16}