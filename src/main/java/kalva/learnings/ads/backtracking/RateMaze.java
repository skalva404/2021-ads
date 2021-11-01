package kalva.learnings.ads.backtracking;

public class RateMaze {

    static int maze[][] = {
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 0, 1},
            {1, 1, 1, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 1, 1, 1}};
    static int r = maze.length;
    static int c = maze.length;
    static int sol[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}};
    static int MOVES = r * c;

    public static void main(String[] args) {
        findPath(0, 0, 0);
        System.out.println("Min steps " + MOVES);
    }

    private static void findPath(int x, int y, int count) {

        if (!canMove(x, y)) {
            return;
        }
        if (x == r - 1 && y == c - 1) {
            sol[x][y] = 1;
            System.out.println("Total steps " + count);
            MOVES = Integer.min(MOVES, count);
            printSolution(sol);
            sol[x][y] = 0;
            return;
        }

        sol[x][y] = 1;
        findPath(x, y + 1, count + 1);
        findPath(x, y - 1, count + 1);
        findPath(x + 1, y, count + 1);
        findPath(x - 1, y, count + 1);
        sol[x][y] = 0;
    }

    public static boolean canMove(int row, int col) {
        return row >= 0 && col >= 0 &&
                row < r && col < c &&
                maze[row][col] == 1 &&
                sol[row][col] == 0;
    }

    static void printSolution(int sol[][]) {
        for (int[] ints : sol) {
            for (int anInt : ints) {
                System.out.print(" " + anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
