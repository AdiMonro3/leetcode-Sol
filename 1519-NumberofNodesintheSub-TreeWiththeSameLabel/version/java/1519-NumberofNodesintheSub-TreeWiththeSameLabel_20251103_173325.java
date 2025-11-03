// Last updated: 03/11/2025, 17:33:25
class Solution {
    private List<Integer>[] adj;
    private String labels;
    private int[] result;

    private int[] dfs(int u, int p) {
        // 1. Create a new count array for this node's subtree
        int[] nodeCounts = new int[26];

        // 2. Recurse on all children
        for (int v : adj[u]) {
            if (v == p) continue; // Skip parent

            // Get the counts from the child's subtree
            int[] childCounts = dfs(v, u);

            // 3. Merge the child's counts into this node's counts
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        // 4. Process current node's label
        char label = labels.charAt(u);
        int labelIndex = label - 'a';

        nodeCounts[labelIndex]++;

        // 5. Store answer for this node
        result[u] = nodeCounts[labelIndex];

        // 6. Return subtree counts to parent
        return nodeCounts;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        this.result = new int[n];

        // Build adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        dfs(0, -1);

        return result;
    }
}
