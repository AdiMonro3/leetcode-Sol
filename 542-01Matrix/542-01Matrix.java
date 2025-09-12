// Last updated: 13/09/2025, 01:49:03
class Solution {
    static class Pair {
        int row;
        int col;
        int dis;

        Pair(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Step 1: Add all 0s to queue, mark 1s as -1 (unvisited)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                } else {
                    mat[i][j] = -1; // mark unvisited
                }
            }
        }

        // Directions: up, right, down, left
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;
            result[row][col] = dis;

            for (int k = 0; k < 4; k++) {
                int newRow = row + dx[k];
                int newCol = col + dy[k];

                // Check bounds and unvisited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = 0; // mark visited
                    q.add(new Pair(newRow, newCol, dis + 1));
                }
            }
        }

        return result;
    }
}