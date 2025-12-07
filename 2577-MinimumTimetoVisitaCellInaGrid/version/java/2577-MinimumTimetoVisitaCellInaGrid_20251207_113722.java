// Last updated: 07/12/2025, 11:37:22
1class Solution {
2     private static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
3
4    public int minimumTime(int[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        // If both initial moves require more than 1 second, return -1
9        if (grid[0][1] > 1 && grid[1][0] > 1) {
10            return -1;
11        }
12
13        boolean[][] visited = new boolean[m][n];
14        int[][] result = new int[m][n];
15        for (int i = 0; i < m; i++) {
16            for (int j = 0; j < n; j++) {
17                result[i][j] = Integer.MAX_VALUE;
18            }
19        }
20
21        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
22        pq.offer(new int[] { grid[0][0], 0, 0 });
23        result[0][0] = 0;
24
25        while (!pq.isEmpty()) {
26            int[] curr = pq.poll();
27            int time = curr[0], row = curr[1], col = curr[2];
28
29            // Reached destination
30            if (row == m - 1 && col == n - 1) {
31                return result[m - 1][n - 1];
32            }
33
34            if (visited[row][col]) continue;
35            visited[row][col] = true;
36
37            for (int[] dir : directions) {
38                int r = row + dir[0];
39                int c = col + dir[1];
40
41                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
42                    continue;
43                }
44
45                int nextTime;
46                if (grid[r][c] <= time + 1) {
47                    nextTime = time + 1;
48                } else if ((grid[r][c] - time) % 2 == 0) {
49                    nextTime = grid[r][c] + 1;
50                } else {
51                    nextTime = grid[r][c];
52                }
53
54                if (nextTime < result[r][c]) {
55                    result[r][c] = nextTime;
56                    pq.offer(new int[] { nextTime, r, c });
57                }
58            }
59        }
60
61        return -1;
62    }
63}