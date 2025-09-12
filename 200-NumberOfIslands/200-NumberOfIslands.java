// Last updated: 13/09/2025, 01:50:50
class Solution {
    class DisjointSet{
        int[] parent;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n + 1];
            size = new int[n + 1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public int FindUParent(int node){
            if(node==parent[node]) return node;
            int ulp=FindUParent(parent[node]);
            parent[node]=ulp;
            return parent[node];
        }
        public void UnionBySize(int u,int v){
            int ulp_u=FindUParent(u);
            int ulp_v=FindUParent(v);
            if(ulp_u==ulp_v) return;
            if(size[ulp_u]<size[ulp_v]){
                parent[ulp_u]=ulp_v;
                size[ulp_v]+=size[ulp_u];
            }
            else{
                parent[ulp_v]=ulp_u;
                size[ulp_u]+=size[ulp_v];
            }
        }
    }
    public boolean isValid(int newr,int newc,int n,int m){
        return newr>=0 && newc>=0 && newr<n && newc<m;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        DisjointSet ds=new DisjointSet(n*m+1);
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j] == '1'){
                int node= i * m + j;
                for(int z=0;z<4;z++){
                    int newr=i+dr[z];
                    int newc=j+dc[z];
                    if(isValid(newr, newc, n, m) && grid[newr][newc] == '1'){
                        int adjNode = newr * m + newc;
                        ds.UnionBySize(node,adjNode);
                    }
                }
            }
        }
    }
        HashSet<Integer> uniqueIslands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    int node = i * m + j;
                    uniqueIslands.add(ds.FindUParent(node));
                }
            }
        }

        return uniqueIslands.size();
    }
}