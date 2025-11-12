// Last updated: 12/11/2025, 12:47:24
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree=new int[n];
        List<HashSet<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
        }

        for(int[] temp:roads){
            int u=temp[0];
            int v=temp[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = indegree[i] + indegree[j];
                if (adj.get(i).contains(j)) rank--; // directly connected → subtract 1
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;

    }
}