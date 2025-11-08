// Last updated: 08/11/2025, 13:21:30
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         int[] indegree = new int[n];

        for (List<Integer> e : edges) {
            indegree[e.get(1)]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) result.add(i);
        }

        return result;
    }
}