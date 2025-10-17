// Last updated: 17/10/2025, 18:49:32
class Solution {
    int[][][][][] dp;
    int[] dr = {-1, 1, 1, -1};
    int[] dc = {1, 1, -1, -1};
    int n, m;

    boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    boolean isClockwise(int from, int to) {
        return (from == 0 && to == 1) ||
               (from == 1 && to == 2) ||
               (from == 2 && to == 3) ||
               (from == 3 && to == 0);
    }

    boolean validNext(int curr, int next) {
        return (curr == 1 && next == 2) ||
               (curr == 2 && next == 0) ||
               (curr == 0 && next == 2);
    }

    int dfs(int i, int j, int cell, int turn, int prevDir, int[][] grid) {
        int dirIndex = prevDir == -1 ? 4 : prevDir; // map -1 to 4 for memo
        if (dp[i][j][cell][turn][dirIndex] != -1) return dp[i][j][cell][turn][dirIndex];

        int maxLen = 0;
        for (int d = 0; d < 4; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];
            if (!isValid(ni, nj)) continue;
            int nextCell = grid[ni][nj];
            if (!validNext(cell, nextCell)) continue;

            if (prevDir == -1 || prevDir == d) { // same direction
                maxLen = Math.max(maxLen, 1 + dfs(ni, nj, nextCell, turn, d, grid));
            } else if (turn == 1 && isClockwise(prevDir, d)) { // one turn allowed
                maxLen = Math.max(maxLen, 1 + dfs(ni, nj, nextCell, 0, d, grid));
            }
        }
        return dp[i][j][cell][turn][dirIndex] = maxLen;
    }

    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][3][2][5];
        for (int[][][][] a : dp)
            for (int[][][] b : a)
                for (int[][] c : b)
                    for (int[] d : c)
                        Arrays.fill(d, -1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // start with 1, check all four directions for 2
                    res = Math.max(res, 1 + dfs(i, j, 1, 1, -1, grid));
                }
            }
        }
        return res;
    }
}
