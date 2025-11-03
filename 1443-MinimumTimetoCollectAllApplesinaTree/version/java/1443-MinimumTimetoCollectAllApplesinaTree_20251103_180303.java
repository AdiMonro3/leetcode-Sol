// Last updated: 03/11/2025, 18:03:03
class Solution {
    private int totalTime;
    private boolean dfs(int u, int p, List<Integer>[] adj, List<Boolean> hasApple) {
        
        // This variable tracks if u OR any of its descendants have an apple.
        // Start by checking node 'u' itself.
        boolean hasAppleInSubtree = hasApple.get(u);
        
        // Iterate over all neighbors
        for (int v : adj[u]) {
            // Don't traverse back up to the parent
            if (v == p) {
                continue;
            }
            
            // Recursively check the child's subtree
            boolean childNeedsVisit = dfs(v, u, adj, hasApple);
            
            // The Core Logic:
            // If the child's subtree (v) needs a visit (has an apple),
            // we MUST traverse the edge (u, v) and (v, u).
            if (childNeedsVisit) {
                // Add 2 seconds for the round trip (u -> v and v -> u)
                this.totalTime += 2;
                
                // Since our child has an apple, our subtree also has one.
                hasAppleInSubtree = true;
            }
        }
        
        // Return to our parent whether this entire branch has an apple.
        return hasAppleInSubtree;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 1. Build the adjacency list (undirected graph)
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        // 2. Initialize totalTime and start the DFS
        this.totalTime = 0;
        dfs(0, -1, adj, hasApple);
        
        // 3. Return the accumulated time
        return this.totalTime;
    }
}