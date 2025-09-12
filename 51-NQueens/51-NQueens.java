// Last updated: 13/09/2025, 01:52:03
class Solution {
    static void solve(int row, char[][] board, List < List < String >> res, int column[], int upperleftDiagonal[], int upperrightDiagonal[]) {
        if (row == board.length) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col< board.length; col++) {
            if (column[col] == 0 && upperleftDiagonal[row-col+board.length-1] == 0 && upperrightDiagonal[row+col] == 0) {
                board[row][col] = 'Q';
                column[col] = 1;
                upperleftDiagonal[row-col+board.length-1] = 1;
                upperrightDiagonal[row+col] = 1;
                solve(row + 1, board, res, column, upperleftDiagonal, upperrightDiagonal);
                board[row][col] = '.';
                column[col] = 0;
                upperleftDiagonal[row-col+board.length-1] = 0;
                upperrightDiagonal[row+col] = 0;
            }
        }
    }


    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int column[] = new int[n];
        int upperleftDiagonal[] = new int[2 * n - 1];
        int upperrightDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, column, upperleftDiagonal, upperrightDiagonal);
        return res;
    }
}