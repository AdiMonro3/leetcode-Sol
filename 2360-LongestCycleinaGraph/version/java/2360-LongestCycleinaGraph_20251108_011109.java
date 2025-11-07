// Last updated: 08/11/2025, 01:11:09
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentSizes.add(dfs(i, graph, visited));
            }
        }

        long ans = 0;
        long remaining = n;

        for (int size : componentSizes) {
            remaining -= size;
            ans += (long) size * remaining;
        }

        return ans;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                    count++;
                }
            }
        }
        return count;
    }
}
