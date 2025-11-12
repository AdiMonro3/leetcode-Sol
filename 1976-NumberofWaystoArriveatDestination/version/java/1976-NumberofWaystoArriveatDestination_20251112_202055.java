// Last updated: 12/11/2025, 20:20:55
import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        // Step 1: Build adjacency list
        // Each entry: graph[u] = list of [v, weight]
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], wt = road[2];
            graph.get(u).add(new long[]{v, wt});
            graph.get(v).add(new long[]{u, wt});
        }

        // Step 2: Initialize data structures
        long[] dist = new long[n];     // shortest distance from 0 → i
        int[] ways = new int[n];       // number of shortest paths to i
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Step 3: Min-heap (priority queue) for Dijkstra
        // Each element: [current distance, node]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        // Step 4: Dijkstra’s algorithm
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            // If we already found a shorter path, skip
            if (d > dist[node]) continue;

            // Explore neighbors
            for (long[] edge : graph.get(node)) {
                int next = (int) edge[0];
                long wt = edge[1];
                long newDist = d + wt;

                // Case 1: Found a strictly shorter path
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{newDist, next});
                }
                // Case 2: Found another shortest path
                else if (newDist == dist[next]) {
                    ways[next] = (int) ((ways[next] + (long) ways[node]) % MOD);
                }
            }
        }

        // Step 5: Return number of shortest paths to destination
        return ways[n - 1];
    }
}
