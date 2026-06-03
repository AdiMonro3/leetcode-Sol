// Last updated: 03/06/2026, 19:25:19
1class Solution {
2    public boolean isToeplitzMatrix(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        for (int i = 1; i < m; i++) {
7            for (int j = 1; j < n; j++) {
8                if (matrix[i][j] != matrix[i - 1][j - 1]) {
9                    return false;
10                }
11            }
12        }
13
14        return true;
15    }
16}