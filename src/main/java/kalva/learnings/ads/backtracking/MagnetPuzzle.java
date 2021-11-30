package kalva.learnings.ads.backtracking;

import java.util.Arrays;

//https://www.techiedelight.com/magnet-puzzle/
public class MagnetPuzzle {

    // `M × N` matrix
    private static final int M = 5;
    private static final int N = 6;

    private static void printSolution(char[][] board) {
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    static int countInColumns(char[][] board, char chr, int column) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (board[i][column] == chr) {
                count++;
            }
        }
        return count;
    }

    static int countInRow(char[][] board, char chr, int row) {
        int count = 0;
        for (char rowDatum : board[row]) {
            if (rowDatum == chr) {
                count++;
            }
        }
        return count;
    }

    static boolean isSafe(char[][] board, int row, int col, char ch,
                          int[] top, int[] left, int[] bottom, int[] right) {

        // check for adjacent cells
        if ((row - 1 >= 0 && board[row - 1][col] == ch) ||
                (col + 1 < N && board[row][col + 1] == ch) ||
                (row + 1 < M && board[row + 1][col] == ch) ||
                (col - 1 >= 0 && board[row][col - 1] == ch)) {
            return false;
        }

        // count character `ch` in the current row
        int rowCount = countInRow(board, ch, row);
        // count character `ch` in the current column
        int colCount = countInColumns(board, ch, col);
        // if the given character is `+`, check `top[]` and `left[]`
        if (ch == '+') {
            // check top
            if (top[col] != -1 && colCount >= top[col]) {
                return false;
            }
            // check left
            if (left[row] != -1 && rowCount >= left[row]) {
                return false;
            }
        }
        // if the given character is `-`, check `bottom[]` and `right[]`
        if (ch == '-') {
            // check bottom
            if (bottom[col] != -1 && colCount >= bottom[col]) {
                return false;
            }
            // check left
            if (right[row] != -1 && rowCount >= right[row]) {
                return false;
            }
        }
        return true;
    }

    static boolean validateConfiguration(char[][] board,
                                         int[] top, int[] left,
                                         int[] bottom, int[] right) {
        for (int i = 0; i < N; i++) {
            if (top[i] != -1 && countInColumns(board, '+', i) != top[i]) {
                return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (bottom[i] != -1 && countInColumns(board, '-', i) != bottom[i]) {
                return false;
            }
        }
        for (int i = 0; i < M; i++) {
            if (left[i] != -1 && countInRow(board, '+', i) != left[i]) {
                return false;
            }
        }
        for (int i = 0; i < M; i++) {
            if (right[i] != -1 && countInRow(board, '-', i) != right[i]) {
                return false;
            }
        }
        return true;
    }

    // The main function to solve the Bipolar Magnets puzzle
    private static boolean solveMagnetPuzzle(char[][] board, int row, int col,
                                             int[] top, int[] left, int[] bottom,
                                             int[] right, char[][] rules) {
        if (row >= M - 1 && col >= N - 1) {
            return validateConfiguration(board, top, left, bottom, right);
        }

        if (col >= M) {
            col = 0;
            row = row + 1;
        }


        // if the current cell contains `R` or `B`
        // (end of horizontal or vertical slot), recur for the next cell


        return false;
    }
}
