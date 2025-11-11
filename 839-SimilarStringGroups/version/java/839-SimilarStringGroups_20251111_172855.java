// Last updated: 11/11/2025, 17:28:55
class Solution {

    private void dfs(int u, boolean[] visited, Map<Integer, List<Integer>> adj) {
        visited[u] = true;

        if (!adj.containsKey(u)) return;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, adj);
            }
        }
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        // adjacency list: which bombs each bomb can trigger
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                // squared distance between bomb i and bomb j
                long dist2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);

                // if bomb i can reach bomb j, add directed edge i -> j
                if (r1 * r1 >= dist2) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        int result = 0;

        // try detonating each bomb
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, visited, adj);

            int count = 0;
            for (boolean v : visited) if (v) count++;

            result = Math.max(result, count);
        }

        return result;
    }
}
