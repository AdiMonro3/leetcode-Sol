// Last updated: 12/11/2025, 14:38:49
class Solution {
    class DSU{
        int[] rank;
        int[] parent;
        int count;

        public DSU(int n){
            count=n;
            rank=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int u){
            if(parent[u]==u) return u;
            return parent[u]=find(parent[u]);
        }
        public void union(int u,int v){
            int up=find(u);
            int vp=find(v);

            if(up==vp) return;

            if(rank[up]>rank[vp]){
                parent[vp]=up;
            }
            else if(rank[up]<rank[vp]){
                parent[up]=vp;
            }
            else{
                parent[vp]=up;
                rank[up]++;
            }
            count--;
        }
    }
    public int mstSum(int n,int [][] adj,int skip,int[] forceEdge){
        int sum=0;
        DSU obj=new DSU(n);
        if (forceEdge != null) {
            obj.union(forceEdge[0], forceEdge[1]);
            sum += forceEdge[2];
        }
        for(int[] temp:adj){
            int u = temp[0], v = temp[1], wt = temp[2], idx=temp[3];
            if(idx==skip) continue;
            if(obj.find(u)!=obj.find(v)){
                obj.union(u, v);
                sum += wt;
            }
        }
        if (obj.count != 1) return Integer.MAX_VALUE;
        return sum;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m=edges.length;
        int[][] adj=new int[m][4];

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            int idx=i;

            adj[i][0]=u;
            adj[i][1]=v;
            adj[i][2]=wt;
            adj[i][3]=idx;
        }
        Arrays.sort(adj,(a,b)-> Integer.compare(a[2],b[2]));
        List<Integer> criticalEdge=new ArrayList<>();
        List<Integer> pseudoCriticalEdge=new ArrayList<>();
        

        int Org_mst_sum=mstSum(n,adj,-1,null);
        for(int i=0;i<m;i++){
            int u = adj[i][0], v = adj[i][1], wt = adj[i][2], idx=adj[i][3];
            if(mstSum(n,adj,idx,null)>Org_mst_sum){
                criticalEdge.add(idx);
            }
            else {
                int[] force = adj[i];
                int forcewt = mstSum(n, adj, -1, force);
                if (forcewt == Org_mst_sum) {
                    pseudoCriticalEdge.add(adj[i][3]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(criticalEdge);
        ans.add(pseudoCriticalEdge);
        return ans;
    }
}