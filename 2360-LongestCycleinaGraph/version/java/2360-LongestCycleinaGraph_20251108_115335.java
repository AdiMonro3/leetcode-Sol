// Last updated: 08/11/2025, 11:53:35
class Solution {
    public int minScore(int n, int[][] roads) {
       List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build adjacency list: (neighbor, distance)
        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int minEdge = Integer.MAX_VALUE;

        // BFS only within the connected component of node 1
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int[] next : graph.get(cur)) {
                int neigh = next[0];
                int dist = next[1];

                // Track minimum edge in this component
                minEdge = Math.min(minEdge, dist);

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    queue.offer(neigh);
                }
            }
        }

        return minEdge;
    }
}