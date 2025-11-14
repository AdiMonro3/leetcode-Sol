// Last updated: 14/11/2025, 14:36:43
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // Step 1: Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        // Step 2: Build graph + populate indegree/outdegree
        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                adj.get(i).add(left);
                indegree[left]++;
                outdegree[i]++;
                if (indegree[left] > 1) return false; // multiple parents
            }

            if (right != -1) {
                adj.get(i).add(right);
                indegree[right]++;
                outdegree[i]++;
                if (indegree[right] > 1) return false; // multiple parents
            }

            if (outdegree[i] > 2) return false; // not binary
        }

        // Step 3: Find the root (node with indegree = 0)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root == -1) root = i; // first root found
                else return false; // multiple roots → invalid
            }
        }
        if (root == -1) return false; // no root found

        // Step 4: DFS to check connectivity & cycles
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(root);
        int visitedCount = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (visited[node]) return false; // cycle detected
            visited[node] = true;
            visitedCount++;

            for (int child : adj.get(node)) {
                if (!visited[child]) st.push(child);
            }
        }

        // Step 5: All nodes must be visited
        return visitedCount == n;
    }
}
