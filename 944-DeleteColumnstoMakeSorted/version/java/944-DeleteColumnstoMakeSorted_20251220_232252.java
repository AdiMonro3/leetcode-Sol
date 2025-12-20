// Last updated: 20/12/2025, 23:22:52
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int rows = strs.length;
4        int cols = strs[0].length();
5        int count = 0;
6
7        for (int j = 0; j < cols; j++) {
8            for (int i = 1; i < rows; i++) {
9                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
10                    count++;
11                    break;
12                }
13            }
14        }
15        return count;
16    }
17}