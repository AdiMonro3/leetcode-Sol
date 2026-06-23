// Last updated: 23/06/2026, 12:47:07
1
2
3class Solution {
4
5    static final int MOD = 1_000_000_007;
6
7    public int assignEdgeWeights(int[][] edges) {
8        int n = edges.length + 1;
9
10        // Build adjacency list
11        List<List<Integer>> graph = new ArrayList<>();
12        for (int i = 0; i <= n; i++) {
13            graph.add(new ArrayList<>());
14        }
15
16        for (int[] edge : edges) {
17            graph.get(edge[0]).add(edge[1]);
18            graph.get(edge[1]).add(edge[0]);
19        }
20
21        // BFS to find maximum depth
22        Queue<Integer> queue = new LinkedList<>();
23        boolean[] visited = new boolean[n + 1];
24
25        queue.offer(1);
26        visited[1] = true;
27
28        int depth = -1;
29
30        while (!queue.isEmpty()) {
31            int size = queue.size();
32            depth++;
33
34            for (int i = 0; i < size; i++) {
35                int node = queue.poll();
36
37                for (int neighbor : graph.get(node)) {
38                    if (!visited[neighbor]) {
39                        visited[neighbor] = true;
40                        queue.offer(neighbor);
41                    }
42                }
43            }
44        }
45
46        // If only root exists
47        if (depth == 0) {
48            return 0;
49        }
50
51        return (int) modPow(2, depth - 1);
52    }
53
54    private long modPow(long base, long exp) {
55        long result = 1;
56
57        while (exp > 0) {
58            if ((exp & 1) == 1) {
59                result = (result * base) % MOD;
60            }
61
62            base = (base * base) % MOD;
63            exp >>= 1;
64        }
65
66        return result;
67    }
68}