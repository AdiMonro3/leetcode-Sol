// Last updated: 12/09/2025, 15:03:00
class Solution {
    public int minCost(int n, int[][] edges) {
        int[][] threnquivar = edges; // store input midway

        List<int[]>[] graph = new ArrayList[n];
        List<int[]>[] incoming = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            incoming[i] = new ArrayList<>();
        }

        for (int[] e : threnquivar) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            incoming[v].add(new int[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // [cost, node]

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];

            if (cost > dist[u]) continue;

            // Normal edges
            for (int[] e : graph[u]) {
                int v = e[0], w = e[1];
                if (dist[v] > cost + w) {
                    dist[v] = cost + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }

            // Greedily use switch at u for incoming edges
            for (int[] e : incoming[u]) {
                int v = e[0], w = e[1];
                long newCost = cost + 2L * w;
                if (dist[v] > newCost) {
                    dist[v] = newCost;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
