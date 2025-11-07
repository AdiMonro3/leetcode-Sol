// Last updated: 08/11/2025, 01:15:02
import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        ArrayList<Long> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                long size = dfs(adj, vis, i);
                components.add(size);
            }
        }

        long ans = 0, total = n;
        for (long size : components) {
            ans += size * (total - size);
            total -= size;
        }

        return ans;
    }

    private long dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node) {
        vis[node] = 1;
        long size = 1;
        for (int nei : adj.get(node)) {
            if (vis[nei] == -1) {
                size += dfs(adj, vis, nei);
            }
        }
        return size;
    }
}
