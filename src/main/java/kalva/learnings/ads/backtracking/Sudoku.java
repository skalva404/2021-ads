package kalva.learnings.ads.backtracking;

public class Sudoku {

    static int counter = 1;

    static boolean usedInRow(int[][] matrix, int row, int num) {
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    static boolean usedInCol(int[][] matrix, int col, int num) {
        for (int[] ints : matrix) {
            if (ints[col] == num) {
                return true;
            }
        }
        return false;
    }

    static boolean usedInBox(int[][] matrix, int row, int col, int num) {
        int mod = (int) Math.sqrt(matrix.length);
        int r = row - row % mod;
        int c = col - col % mod;
        for (int i = r; i < r + mod; i++) {
            for (int j = c; j < c + mod; j++) {
                if (matrix[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] b) {
        int buffer = (int) Math.sqrt(b.length);
        System.out.println("Solution ==> " + (counter++));
        String btm = new String(new char[buffer * buffer * 3 + buffer + 1]).replace("\0", "_");

        for (int i = 0; i < b.length; i++) {
            if (i % buffer == 0)
                System.out.println(btm);
            for (int j = 0; j < b[i].length; j++) {
                if (j % buffer == 0)
                    System.out.print("|");
                if (b[i][j] == 0)
                    System.out.print(" _ ");
                else
                    System.out.print(" " + b[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(btm);
        if (counter > 100) {
            System.exit(0);
        }
    }

    static boolean legalMove(int[][] m, int row, int col, int number) {
        return !(usedInRow(m, row, number) ||
                usedInCol(m, col, number) ||
                usedInBox(m, row, col, number));
    }

    static void solveBacktrack(int[][] b, int row, int col) {

        if (b[row][col] != 0) {
            if (col == b.length - 1) {
                if (row == b.length - 1) {
                    printBoard(b);
                } else {
                    solveBacktrack(b, row + 1, 0);
                }
            } else {
                solveBacktrack(b, row, col + 1);
            }
        }

        for (int k = 1; k <= b.length; k++) {
            if (!legalMove(b, row, col, k)) {
                continue;
            }
            b[row][col] = k;
            if (col == b.length - 1) {
                if (row == b.length - 1) {
                    return;
                } else {
                    solveBacktrack(b, row + 1, 0);
                }
            } else {
                solveBacktrack(b, row, col + 1);
            }
            b[row][col] = 0;
        }
    }

    public static void main(String[] args) {

        int[][] sudokuGrid = {
                {3, 0, 4, 0},
                {0, 2, 0, 1},
                {2, 0, 0, 4},
                {0, 4, 2, 0}
        };
//        int[][] sudokuGrid = {
//                {5, 3, 0, 0, 7, 0, 0, 0, 0},
//                {6, 0, 0, 1, 9, 5, 0, 0, 0},
//                {0, 9, 8, 0, 0, 0, 0, 6, 0},
//                {8, 0, 0, 0, 6, 0, 0, 0, 3},
//                {4, 0, 0, 8, 0, 3, 0, 0, 1},
//                {7, 0, 0, 0, 2, 0, 0, 0, 6},
//                {0, 6, 0, 0, 0, 0, 2, 8, 0},
//                {0, 0, 0, 4, 1, 9, 0, 0, 5},
//                {0, 0, 0, 0, 8, 0, 0, 7, 9}
//        };
        solveBacktrack(sudokuGrid, 0, 0);
        System.out.println(counter);
    }
}
