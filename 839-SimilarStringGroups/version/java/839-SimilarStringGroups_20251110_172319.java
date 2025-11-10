// Last updated: 10/11/2025, 17:23:19
class Solution {
    int parent[];
    int rank[];
    public int find(int u){
        if(parent[u]==u) return u;
        int temp=find(parent[u]);

        parent[u]=temp;
        return temp;
    }
    public void unionByRank(int u,int v){
        int u_parent=find(u);
        int v_parent=find(v);

        if(u_parent==v_parent) return ;

        if(rank[u_parent]>rank[v_parent]){
            parent[v_parent]=u_parent;
        }
        else if(rank[v_parent]>rank[u_parent]){
                parent[u_parent]=v_parent;
        }else{
                parent[v_parent]=u_parent;
                rank[u_parent]++;
        }

    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        List<List<Integer>> queryList=new ArrayList<>();
       int m = queries.length;
        for(int i=0;i<m;i++){
            List<Integer> temp=new ArrayList<>();
            int u=queries[i][0];
            int v=queries[i][1];
            int dist=queries[i][2];
            temp.add(queries[i][0]); // u
            temp.add(queries[i][1]); // v
            temp.add(queries[i][2]); // limit
            temp.add(i);             // original index
            queryList.add(temp);
        }
        queryList.sort(Comparator.comparingInt(a -> a.get(2)));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        boolean[] res = new boolean[m];
        int edgeIdx = 0;

        for (List<Integer> q : queryList) {
            int u = q.get(0);
            int v = q.get(1);
            int limit = q.get(2);
            int queryIdx = q.get(3);

            // Union all edges with weight < limit
            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < limit) {
                unionByRank(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }

            // Check if connected
            res[queryIdx] = (find(u) == find(v));
        }

         return res;
    }
}