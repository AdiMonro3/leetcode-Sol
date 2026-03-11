// Last updated: 11/03/2026, 14:54:05
1class Solution {
2    int n;
3    int m;
4    int[] dr={-1,0,1,0};
5    int[] dc={0,1,0,-1};
6    public boolean isSafe(int i,int j){
7        if(i<0||j<0||i>=n||j>=m) return false;
8        return true;
9    }
10    public int helper(int[][] grid,int i,int j){
11
12        int gold = grid[i][j];
13    grid[i][j] = 0; // mark visited
14
15    int best = 0;
16
17    for(int d=0; d<4; d++){
18        int nr = i + dr[d];
19        int nc = j + dc[d];
20
21        if(isSafe(nr,nc) && grid[nr][nc] != 0){
22            best = Math.max(best, helper(grid,nr,nc));
23        }
24    }
25
26    grid[i][j] = gold; // backtrack
27
28    return gold + best;
29    }
30    public int getMaximumGold(int[][] grid) {
31        n = grid.length;
32    m = grid[0].length;
33
34    int ans = 0;
35
36    for(int i=0;i<n;i++){
37        for(int j=0;j<m;j++){
38            if(grid[i][j] != 0){
39                ans = Math.max(ans, helper(grid,i,j));
40            }
41        }
42    }
43
44    return ans;
45    }
46}