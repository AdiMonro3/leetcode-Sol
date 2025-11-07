// Last updated: 07/11/2025, 21:25:35
class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int [] indegree=new int[n];
        for(int i=0;i<n;i++){
            if(edges[i]!=-1){
                indegree[edges[i]]++;
            }
        }

        Queue<Integer> queue=new LinkedList<>();
         for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

         while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u];
            if (v != -1) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int longest = -1;

         for (int i = 0; i < n; i++) {
            if (indegree[i] > 0 && !visited[i]) {
                int current = i;
                int length = 0;

                while (!visited[current]) {
                    visited[current] = true;
                    current = edges[current];
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
        
    }
}