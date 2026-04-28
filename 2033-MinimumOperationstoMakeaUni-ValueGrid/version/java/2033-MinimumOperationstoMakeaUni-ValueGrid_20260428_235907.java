// Last updated: 28/04/2026, 23:59:07
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length;
4        int ans = Integer.MAX_VALUE;
5
6        for (int i = 0; i < n; i++) {
7            if (words[i].equals(target)) {
8                int diff = Math.abs(i - startIndex);
9                int dist = Math.min(diff, n - diff);
10                ans = Math.min(ans, dist);
11            }
12        }
13
14        return ans == Integer.MAX_VALUE ? -1 : ans;
15    }
16}