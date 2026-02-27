// Last updated: 28/02/2026, 00:27:07
1class Solution {
2    
3    public int minFallingPathSum(int[][] grid) {
4         int n = grid.length;
5
6        int[][] t = new int[n][n];
7        for (int[] row : t) {
8            Arrays.fill(row, Integer.MAX_VALUE);
9        }
10
11        int nextMin1Col = -1;
12        int nextMin2Col = -1;
13        
14        for (int col = 0; col < n; col++) {
15            t[n - 1][col] = grid[n - 1][col];
16            
17            if(nextMin1Col == -1 || t[n - 1][col] <= t[n-1][nextMin1Col]) {
18                nextMin2Col = nextMin1Col;
19                nextMin1Col = col;
20            } else if(nextMin2Col == -1 || t[n - 1][col] <= t[n-1][nextMin2Col]) {
21                nextMin2Col = col;
22            }
23        }
24
25        for (int row = n - 2; row >= 0; row--) {
26            
27            int min1Col = -1;
28            int min2Col = -1;
29            
30            for (int col = 0; col < n; col++) {
31                
32                if(col != nextMin1Col) {
33                    t[row][col] = grid[row][col] + t[row+1][nextMin1Col];
34                } else {
35                    t[row][col] = grid[row][col] + t[row+1][nextMin2Col];
36                }
37                
38                if(min1Col == -1 || t[row][col] <= t[row][min1Col]) {
39                    min2Col = min1Col;
40                    min1Col = col;
41                } else if(min2Col == -1 || t[row][col] <= t[row][min2Col]) {
42                    min2Col = col;
43                }
44            }
45                            
46            nextMin1Col = min1Col;
47            nextMin2Col = min2Col;
48                
49        }
50
51        int result = Integer.MAX_VALUE;
52        for (int col = 0; col < n; col++) {
53            result = Math.min(result, t[0][col]);
54        }
55
56        return result;
57
58    }
59}