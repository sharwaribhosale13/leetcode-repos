import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, ans,
                new int[n],
                new int[2 * n - 1],
                new int[2 * n - 1]);

        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans,
                       int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {

        if (col == board.length) {

            List<String> temp = new ArrayList<>();

            for (char[] row : board)
                temp.add(new String(row));

            ans.add(temp);
            return;
        }

        for (int row = 0; row < board.length; row++) {

            if (leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[board.length - 1 + col - row] == 0) {

                board[row][col] = 'Q';

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                solve(col + 1, board, ans, leftRow, upperDiagonal, lowerDiagonal);

                board[row][col] = '.';

                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}