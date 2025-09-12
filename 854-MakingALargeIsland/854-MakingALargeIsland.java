// Last updated: 13/09/2025, 01:48:30
class Solution {
    class DisjointSet{
        int[] size;
        int[] parent;
        public DisjointSet(int n){
            size = new int[n + 1]; 
            parent = new int[n + 1];  
            for(int i=0;i<=n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }
        public int FindUParent(int node){
            if(node==parent[node]) return node;
            int ulp=FindUParent(parent[node]);
            parent[node]=ulp;
            return parent[node];
        }
        public void UnionBySize(int u,int v){
        int ulp_u = FindUParent(u);
        int ulp_v = FindUParent(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u]< size[ulp_v]) {
            parent[ulp_u]=ulp_v;
            size[ulp_v] =size[ulp_v] + size[ulp_u];
        } else {
            parent[ulp_v]= ulp_u;
            size[ulp_u] =size[ulp_u] + size[ulp_v];
        }
        }
    }
    public static boolean isValid(int row,int col,int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    public int largestIsland(int[][] grid) {
        int n= grid.length;
        DisjointSet ds=new DisjointSet((n*n)+1);
        int dr[] = { -1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int k=0;k<4;k++){
                    int newr=i+dr[k];
                    int newc=j+dc[k];
                    if(isValid(newr,newc,n)&& grid[newr][newc]==1){
                        int nodeno=i*n+j;
                        int adjnodeno=newr*n+newc;
                        ds.UnionBySize( nodeno, adjnodeno);
                    }

                }
            }
        }
         int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.FindUParent(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size[parents];
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size[ds.FindUParent(cellNo)]);
        }
        return mx;

        
    }
}