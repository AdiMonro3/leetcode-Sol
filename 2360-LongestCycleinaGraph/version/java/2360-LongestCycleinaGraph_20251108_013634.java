// Last updated: 08/11/2025, 01:36:34
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph with direction marker
        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], 1}); // original direction (needs reverse)
            graph.get(c[1]).add(new int[]{c[0], 0}); // reverse direction (already correct)
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] nei : graph.get(node)) {
            int next = nei[0];
            int cost = nei[1];

            if (!visited[next]) {
                changes += cost; // if cost==1, we need to reverse this edge
                changes += dfs(next, graph, visited);
            }
        }
        return changes;
    }
}
