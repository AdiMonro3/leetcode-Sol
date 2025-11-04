// Last updated: 04/11/2025, 16:12:02
class Solution {
    private void dfs2(List<List<Integer>> adj,int n,int node, int parent,int [] countnode,int []distSum ){
        for (int child : adj.get(node)) {
            if (child == parent) continue;
            distSum[child] = distSum[node] - countnode[child] + (n - countnode[child]);
            dfs2(adj,n,child, node,countnode,distSum);
        }

    }
    public int dfs1(List<List<Integer>> adj,int node ,int parent,int dist,int [] countnode ){
        int count=dist;
        countnode[node]=1;
        for(int i: adj.get(node)){
            if(i== parent) continue;
            count+=dfs1(adj,i,node,dist+1,countnode);

            countnode[node]+=countnode[i];

        }
        return count;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int [] countnode=new int[n];
        int[] distSum=new int[n];

        
       List<List<Integer>> adj = new ArrayList<>();
        
        // 2. CRUCIAL: Add 'n' empty inner lists to represent each node
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 3. Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // Because it's undirected, add an edge in both directions
            // We use .get(index) to access the list for that node
            adj.get(u).add(v); // Add v to u's list
            adj.get(v).add(u); // Add u to v's list
        }
        distSum[0]=dfs1(adj,0, -1,0,countnode);
        dfs2(adj,n,0, -1,countnode,distSum);
        
        return distSum;
    }
}