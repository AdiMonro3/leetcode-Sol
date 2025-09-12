// Last updated: 13/09/2025, 01:47:51
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid=new int[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        int[] cities=new int[n];
        for(int i=0;i<n;i++){
            grid[i][i]=0;
        }
        for(int[] it:edges){
            int from=it[0];
            int to=it[1];
            int wt=it[2];
            grid[from][to]=wt;
            grid[to][from]=wt;
        }
        for(int via=0;via<n;via++){
            for( int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                     if (grid[i][via] != Integer.MAX_VALUE && grid[via][j] != Integer.MAX_VALUE) {
                    grid[i][j]=Math.min(grid[i][j],grid[i][via]+grid[via][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<=distanceThreshold && i!=j) cities[i]++;
            }
        }
        int lowest=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=n-1;i>=0;i--){
           if(cities[i]<lowest){
            lowest=cities[i];
            ans=i;
           }
        }

        return ans;
    }
}