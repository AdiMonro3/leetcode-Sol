// Last updated: 02/07/2026, 02:44:56
1class Solution {
2
3    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
4
5    public int maximumSafenessFactor(List<List<Integer>> grid) {
6
7        int n = grid.size();
8
9        int[][] dist = new int[n][n];
10
11        for (int[] row : dist)
12            Arrays.fill(row, -1);
13
14        Queue<int[]> q = new LinkedList<>();
15
16        // Multi-source BFS
17        for (int i = 0; i < n; i++) {
18            for (int j = 0; j < n; j++) {
19                if (grid.get(i).get(j) == 1) {
20                    dist[i][j] = 0;
21                    q.offer(new int[]{i, j});
22                }
23            }
24        }
25
26        while (!q.isEmpty()) {
27
28            int[] cur = q.poll();
29
30            int x = cur[0];
31            int y = cur[1];
32
33            for (int[] d : dirs) {
34
35                int nx = x + d[0];
36                int ny = y + d[1];
37
38                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == -1) {
39
40                    dist[nx][ny] = dist[x][y] + 1;
41                    q.offer(new int[]{nx, ny});
42                }
43            }
44        }
45
46        int low = 0;
47        int high = 2 * n;
48
49        while (low <= high) {
50
51            int mid = low + (high - low) / 2;
52
53            if (canReach(dist, mid)) {
54                low = mid + 1;
55            } else {
56                high = mid - 1;
57            }
58        }
59
60        return high;
61    }
62
63    private boolean canReach(int[][] dist, int safe) {
64
65        int n = dist.length;
66
67        if (dist[0][0] < safe)
68            return false;
69
70        Queue<int[]> q = new LinkedList<>();
71        boolean[][] vis = new boolean[n][n];
72
73        q.offer(new int[]{0, 0});
74        vis[0][0] = true;
75
76        while (!q.isEmpty()) {
77
78            int[] cur = q.poll();
79
80            int x = cur[0];
81            int y = cur[1];
82
83            if (x == n - 1 && y == n - 1)
84                return true;
85
86            for (int[] d : dirs) {
87
88                int nx = x + d[0];
89                int ny = y + d[1];
90
91                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
92                        !vis[nx][ny] &&
93                        dist[nx][ny] >= safe) {
94
95                    vis[nx][ny] = true;
96                    q.offer(new int[]{nx, ny});
97                }
98            }
99        }
100
101        return false;
102    }
103}