// Last updated: 14/11/2025, 19:05:55
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n + 1];
        
        // Build adjacency list & indegree
        for (int[] rel : relations) {
            int u = rel[0];
            int v = rel[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] finishTime = new int[n + 1]; // finish time for each course

        // Start with all courses having no prerequisites
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                finishTime[i] = time[i - 1]; // courses are 1-indexed, time[] is 0-indexed
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                // The earliest we can finish v = max of all prerequisite finish times + v's own time
                finishTime[v] = Math.max(finishTime[v], finishTime[u] + time[v - 1]);
                
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // The total time = the longest finish time among all courses
        int mintime = 0;
        for (int i = 1; i <= n; i++) {
            mintime = Math.max(mintime, finishTime[i]);
        }

        return mintime;
    }
}
