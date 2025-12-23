// Last updated: 23/12/2025, 11:11:21
1class Solution {
2    public int maxTwoEvents(int[][] events) {
3        // Sort by end time
4        Arrays.sort(events, (a, b) -> a[1] - b[1]);
5
6        int n = events.length;
7        int[] best = new int[n];
8
9        // Prefix max of values
10        best[0] = events[0][2];
11        for (int i = 1; i < n; i++) {
12            best[i] = Math.max(best[i - 1], events[i][2]);
13        }
14
15        int ans = best[0];
16
17        for (int i = 0; i < n; i++) {
18            int start = events[i][0];
19            int value = events[i][2];
20
21            // Binary search for last event ending before start
22            int l = 0, r = i - 1, idx = -1;
23            while (l <= r) {
24                int mid = (l + r) / 2;
25                if (events[mid][1] < start) {
26                    idx = mid;
27                    l = mid + 1;
28                } else {
29                    r = mid - 1;
30                }
31            }
32
33            if (idx != -1) {
34                ans = Math.max(ans, value + best[idx]);
35            } else {
36                ans = Math.max(ans, value);
37            }
38        }
39
40        return ans;
41    }
42}