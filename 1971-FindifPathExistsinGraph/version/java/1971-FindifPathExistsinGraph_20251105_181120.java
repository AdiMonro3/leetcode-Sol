// Last updated: 05/11/2025, 18:11:20
class Solution {
    List<List<Integer>> graph;
    String s;
    int answer = 1;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        int n = parent.length;

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 1; i < n; i++)
            graph.get(parent[i]).add(i);

        dfs(0);
        return answer;
    }

    private int dfs(int node) {
        int longest = 0, secondLongest = 0;

        for (int child : graph.get(node)) {
            int childLen = dfs(child);

            if (s.charAt(child) == s.charAt(node)) continue;

            if (childLen > longest) {
                secondLongest = longest;
                longest = childLen;
            } else if (childLen > secondLongest) {
                secondLongest = childLen;
            }
        }

        answer = Math.max(answer, longest + secondLongest + 1);
        return longest + 1;
    }
}
