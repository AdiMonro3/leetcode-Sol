// Last updated: 22/12/2025, 00:23:21
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5        
6        boolean[] sorted = new boolean[n - 1];
7        int deletions = 0;
8
9        for (int col = 0; col < m; col++) {
10            boolean bad = false;
11
12            // Check if this column breaks order
13            for (int i = 0; i < n - 1; i++) {
14                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
15                    bad = true;
16                    break;
17                }
18            }
19
20            if (bad) {
21                deletions++;
22                continue;
23            }
24
25            // Update sorted pairs
26            for (int i = 0; i < n - 1; i++) {
27                if (!sorted[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
28                    sorted[i] = true;
29                }
30            }
31        }
32
33        return deletions;
34    }
35}