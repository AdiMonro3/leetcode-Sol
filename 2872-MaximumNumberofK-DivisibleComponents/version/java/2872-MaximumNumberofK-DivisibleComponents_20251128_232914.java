// Last updated: 28/11/2025, 23:29:14
1class Solution {
2    int maxComponents = 0; // Global counter for valid component
3    private long dfs(int currentNode, int parentNode, List<List<Integer>> adj, int[] values, int k) {
4        long currentSum = values[currentNode];
5
6        for (int neighbor : adj.get(currentNode)) {
7            // Avoid going back up the tree to the parent
8            if (neighbor != parentNode) {
9                // Add the sum from the child (if the child didn't cut itself off)
10                currentSum += dfs(neighbor, currentNode, adj, values, k);
11            }
12        }
13
14        // 3. The Greedy Check
15        // If the sum of this subtree is divisible by k, it forms a valid component.
16        if (currentSum % k == 0) {
17            maxComponents++;
18            return 0; // We cut the edge, so we return 0 to the parent
19        }
20
21        // Otherwise, return the sum to be combined with the parent
22        return currentSum;
23    }
24    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
25        List<List<Integer>> adj = new ArrayList<>();
26        for (int i = 0; i < n; i++) {
27            adj.add(new ArrayList<>());
28        }
29        for (int[] edge : edges) {
30            adj.get(edge[0]).add(edge[1]);
31            adj.get(edge[1]).add(edge[0]);
32        }
33
34        // 2. Start DFS from node 0 (root doesn't matter in undirected tree)
35        dfs(0, -1, adj, values, k);
36
37        return maxComponents;
38    }
39}