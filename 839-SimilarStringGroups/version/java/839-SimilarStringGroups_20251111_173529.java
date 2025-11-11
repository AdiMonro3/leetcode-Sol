// Last updated: 11/11/2025, 17:35:29
class Solution {

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long dist2 = dx * dx + dy * dy;

                long r1sq = (long) bombs[i][2] * bombs[i][2];
                long r2sq = (long) bombs[j][2] * bombs[j][2];

                if (r1sq >= dist2) adj.get(i).add(j);
                if (r2sq >= dist2) adj.get(j).add(i);
            }
        }

        int maxDetonations = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, visited, adj);

            int count = 0;
            for (boolean v : visited) if (v) count++;

            maxDetonations = Math.max(maxDetonations, count);
        }

        return maxDetonations;
    }
}
