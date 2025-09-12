// Last updated: 12/09/2025, 15:03:17
class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        long[][] graph = new long[n][];
        for (int i = 0; i < n; i++) graph[i] = new long[n];
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]][roads[i][1]] = roads[i][2];
            graph[roads[i][1]][roads[i][0]] = roads[i][2];
        }

        long[] dist = new long[n];
        int[] count = new int[n];
        boolean[] vist = new boolean[n];
        for (int i = 0; i < n; i++) dist[i] = Long.MAX_VALUE;
        dist[0] = 0;
        count[0] = 1;
        for (int i = 0; i < n; i++) {
            long min = Long.MAX_VALUE;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vist[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            if (u < 0) break;
            vist[u] = true;
            for (int j = 0; j < n; j++) {
                if (!vist[j] && graph[u][j] != 0) {
                    long timei = dist[u] + graph[u][j];
                    if (timei < dist[j]) {
                        dist[j] = timei;
                        count[j] = count[u]  % MOD;
                    } else if (timei == dist[j]) count[j] = (count[j] + count[u]) % MOD;
                }
            }
        }
        return count[n-1];
    }
}