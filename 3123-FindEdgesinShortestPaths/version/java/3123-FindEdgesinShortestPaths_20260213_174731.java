// Last updated: 13/02/2026, 17:47:31
1class Solution {
2
3    class Pair {
4        int node;
5        long wt;
6        Pair(int n, long w) {
7            node = n;
8            wt = w;
9        }
10    }
11
12    public long[] dijkstra(List<List<Pair>> adj, int src) {
13        int n = adj.size();
14        long[] dist = new long[n];
15        Arrays.fill(dist, Long.MAX_VALUE);
16
17        PriorityQueue<Pair> pq =
18                new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));
19
20        dist[src] = 0;
21        pq.offer(new Pair(src, 0));
22
23        while (!pq.isEmpty()) {
24            Pair cur = pq.poll();
25            int u = cur.node;
26            long d = cur.wt;
27
28            if (d > dist[u]) continue;
29
30            for (Pair p : adj.get(u)) {
31                int v = p.node;
32                long w = p.wt;
33
34                if (dist[v] > dist[u] + w) {
35                    dist[v] = dist[u] + w;
36                    pq.offer(new Pair(v, dist[v]));
37                }
38            }
39        }
40        return dist;
41    }
42
43    public boolean[] findAnswer(int n, int[][] edges) {
44
45        List<List<Pair>> adj = new ArrayList<>();
46        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
47
48        for (int[] e : edges) {
49            adj.get(e[0]).add(new Pair(e[1], e[2]));
50            adj.get(e[1]).add(new Pair(e[0], e[2]));
51        }
52
53        long[] d1 = dijkstra(adj, 0);
54        long[] d2 = dijkstra(adj, n - 1);
55
56        long total = d1[n - 1];
57
58        boolean[] ans = new boolean[edges.length];
59
60        for (int i = 0; i < edges.length; i++) {
61            int u = edges[i][0];
62            int v = edges[i][1];
63            int w = edges[i][2];
64
65            if ((d1[u] + w == d1[v] && d1[u] + w + d2[v] == total) ||
66    (d1[v] + w == d1[u] && d1[v] + w + d2[u] == total)) {
67    ans[i] = true;
68}
69
70        }
71
72        return ans;
73    }
74}
75