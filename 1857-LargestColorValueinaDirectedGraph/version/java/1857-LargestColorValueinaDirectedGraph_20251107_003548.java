// Last updated: 07/11/2025, 00:35:48
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        int[] indegree = new int[n];

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q=new ArrayDeque<>();
        int[][] dp = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                // Initialize the count for the start node's own color
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }
        int nodesSeen = 0;
        int maxColorValue = 0;

        // 3. Process nodes (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int u = q.poll();
            nodesSeen++;
            
            // Update the global maximum with the best value found at this node.
            // We only need to check 'u's own color, as it's the only one 
            // that just increased at this step.
            maxColorValue = Math.max(maxColorValue, dp[u][colors.charAt(u) - 'a']);

            for (int v : adj.get(u)) {
                // Pass history from u to v for all 26 colors
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c]);
                }
                
                // If v has no more incoming dependencies
                indegree[v]--;
                if (indegree[v] == 0) {
                    // Add v's own color to its paths now that it's ready
                    dp[v][colors.charAt(v) - 'a']++;
                    q.offer(v);
                }
            }
        }

        // 4. Cycle detected if we didn't process all nodes
        if (nodesSeen < n) {
            return -1;
        }

        return maxColorValue;
    }

}