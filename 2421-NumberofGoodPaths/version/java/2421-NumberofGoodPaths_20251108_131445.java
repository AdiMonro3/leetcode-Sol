// Last updated: 08/11/2025, 13:14:45
class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Group nodes by value
        Map<Integer, List<Integer>> valueToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valueToNodes.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        UnionFind uf = new UnionFind(n);
        int goodPaths = 0;
        int[] count = new int[n]; // counts nodes of same value per component

        for (int value : valueToNodes.keySet()) {
            // For all nodes with this value, union them with neighbors
            for (int node : valueToNodes.get(value)) {
                for (int nei : graph.get(node)) {
                    if (vals[nei] <= value) {
                        uf.union(node, nei);
                    }
                }
            }

            // Count occurrences of this value per component root
            Map<Integer, Integer> compCount = new HashMap<>();
            for (int node : valueToNodes.get(value)) {
                int root = uf.find(node);
                compCount.put(root, compCount.getOrDefault(root, 0) + 1);
            }

            // Contribution from this value group
            for (int c : compCount.values()) {
                goodPaths += c * (c + 1) / 2;   // number of good paths inside component
            }
        }

        return goodPaths;
    }

    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}
