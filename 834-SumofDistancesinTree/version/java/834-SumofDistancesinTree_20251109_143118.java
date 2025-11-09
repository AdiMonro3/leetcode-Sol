// Last updated: 09/11/2025, 14:31:18
class Solution {
    int[] countNode;
    int[] dist;
    public int dfs1(List<List<Integer>> adj,int node,int parent,int level){
        countNode[node]=1;
        dist[0]+=level;
        for(int i:adj.get(node)){
            if(i!=parent){
                countNode[node]+=dfs1(adj,i,node,level+1);
            }
        }
        return countNode[node];
    }
    public void dfs2(List<List<Integer>> adj ,int n,int node ,int parent){
        for (int child : adj.get(node)) {
            if (child != parent) {
                dist[child] = dist[node] - countNode[child] + (n - countNode[child]);
            dfs2(adj, n,child, node);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        countNode=new int[n];
        dist=new int[n];

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
        dfs1(adj,0, -1,0);
        dfs2(adj,n,0, -1);
        
        return dist;

    }
}