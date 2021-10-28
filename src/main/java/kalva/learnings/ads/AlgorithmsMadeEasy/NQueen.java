package kalva.learnings.ads.AlgorithmsMadeEasy;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    List<List<String>> result = null;

    public NQueen solveNQueens(int n) {

        result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, new ArrayList<>());
        return this;
    }

    private void dfs(char[][] board, int r, List<int[]> queens) {

        if (queens.size() == board.length) {
            List<String> rows = new ArrayList<>();
            for (char[] row : board) {
//                rows.add(new String(row));
                rows.add(getLine(row));
            }
            result.add(rows);
        }
        for (int c = 0; c < board.length; c++) {
            if (canAdd(r, c, queens)) {
                board[r][c] = 'Q';
                queens.add(new int[]{r, c});
                dfs(board, r + 1, queens);
                board[r][c] = '.';
                queens.remove(queens.size() - 1);
            }
        }
    }

    private String getLine(char[] row) {
        StringBuilder sb = new StringBuilder();
        for (char c : row) {
            sb.append(c).append("  ");
        }
        return sb.toString();
    }

    private boolean canAdd(int r, int c, List<int[]> queens) {
        for (int[] q : queens) {
            int dx = Math.abs(r - q[0]);
            int dy = Math.abs(c - q[1]);
            if (0 == dx || 0 == dy || dx == dy) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (List<String> mats : result) {
            for (String loc : mats) {
                System.out.println(loc);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new NQueen().solveNQueens(6).print();
//        new NQueen().solveNQueens(1).print();
    }
}
