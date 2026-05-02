// Last updated: 02/05/2026, 22:40:24
1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        for (int i = 0; i < k / 2; i++) {
4
5            int row1 = x + i;
6            int row2 = x + k - 1 - i;
7
8            for (int j = 0; j < k; j++) {
9                int col = y + j;
10
11                int temp = grid[row1][col];
12                grid[row1][col] = grid[row2][col];
13                grid[row2][col] = temp;
14            }
15        }
16
17        return grid;
18    }
19}