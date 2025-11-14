// Last updated: 14/11/2025, 17:47:13
class Solution {
    Map<Integer, Deque<Integer>> graph = new HashMap<>();
    List<int[]> path = new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        // Step 1: Build graph
        for (int[] p : pairs) {
            graph.computeIfAbsent(p[0], k -> new ArrayDeque<>()).add(p[1]);
            outdegree.put(p[0], outdegree.getOrDefault(p[0], 0) + 1);
            indegree.put(p[1], indegree.getOrDefault(p[1], 0) + 1);
        }

        // Step 2: Find start node
        int start = pairs[0][0];
        for (int node : outdegree.keySet()) {
            int out = outdegree.getOrDefault(node, 0);
            int in = indegree.getOrDefault(node, 0);
            if (out - in == 1) {
                start = node;
                break;
            }
        }

        // Step 3: Hierholzer’s DFS
        dfs(start);

        // Step 4: Reverse path
        Collections.reverse(path);
        int[][] res = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) res[i] = path.get(i);
        return res;
    }

    private void dfs(int node) {
        Deque<Integer> stack = graph.getOrDefault(node, new ArrayDeque<>());
        while (!stack.isEmpty()) {
            int next = stack.pollFirst();
            dfs(next);
            path.add(new int[]{node, next});
        }
    }
}
