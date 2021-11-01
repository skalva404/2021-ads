package kalva.learnings.ads.backtracking;

/**
 * https://algorithms.tutorialhorizon.com/backtracking-knights-tour-problem
 */
public class KnightsTour {

    static int count = 0;

    public static void main(String[] args) {
        int n = 8;
        int arr[][] = new int[n][n];
        printKnightsTour(arr, 0, 0, 1);
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int move) {

        if (!canMove(chess, row, col)) return;

        if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        printKnightsTour(chess, row - 2, col + 1, move + 1);
        printKnightsTour(chess, row - 1, col + 2, move + 1);
        printKnightsTour(chess, row + 1, col + 2, move + 1);
        printKnightsTour(chess, row + 2, col + 1, move + 1);
        printKnightsTour(chess, row + 2, col - 1, move + 1);
        printKnightsTour(chess, row + 1, col - 2, move + 1);
        printKnightsTour(chess, row - 1, col - 2, move + 1);
        printKnightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private static boolean canMove(int[][] chess, int row, int col) {
        return row < chess.length && col < chess.length &&
                row >= 0 && col >= 0 &&
                chess[row][col] == 0;
    }

    public static void displayBoard(int[][] chess) {
        System.out.println("Sol " + (++count));
        for (int[] ints : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
