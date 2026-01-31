// Last updated: 31/01/2026, 11:34:30
1class Solution {
2    int[]dr={-1,0,1,0};
3    int[]dc={0,1,0,-1};
4    boolean[][] visited;
5    int n;
6    int m;
7    public int helper(int[][] grid,int i,int j){
8        visited[i][j]=true;
9        // if(grid[i][j]==0) return 0;
10        int sum=grid[i][j];
11        for(int d=0;d<4;d++){
12            int nr=i+dr[d];
13            int nc=j+dc[d];
14
15            if(nr>=0&& nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]!=0){
16                sum+=helper(grid,nr,nc);
17            }
18
19        }
20
21        return sum;
22    }
23    public int findMaxFish(int[][] grid) {
24        n=grid.length;
25        m=grid[0].length;
26        visited=new boolean[n][m];
27        int res=0;
28        for(int i=0;i<n;i++){
29            for(int j=0;j<m;j++){
30                if(!visited[i][j] && grid[i][j]!=0){
31                    res=Math.max(res,helper(grid,i,j));
32                }
33            }
34        }
35        return res;
36    }
37}