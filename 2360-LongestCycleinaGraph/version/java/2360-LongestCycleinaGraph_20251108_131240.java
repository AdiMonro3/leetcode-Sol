// Last updated: 08/11/2025, 13:12:40
class Solution {
    public void dfs(int node, int[] edges, int[] dist, int d){
       if (node == -1 || dist[node] != -1) return;  // stop if no edge OR already visited
        dist[node] = d;
        dfs(edges[node], edges, dist, d + 1);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        // DFS from node1 and node2
        dfs(node1, edges, dist1, 0);
        dfs(node2, edges, dist2, 0);

        int answer = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {  // reachable from both
                int maxD = Math.max(dist1[i], dist2[i]);
                if (maxD < minDist) {
                    minDist = maxD;
                    answer = i;
                }
            }
        }
        return answer;
    }
}