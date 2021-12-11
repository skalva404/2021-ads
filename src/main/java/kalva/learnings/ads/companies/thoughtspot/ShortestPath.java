package kalva.learnings.ads.companies.thoughtspot;

import static java.lang.Integer.MAX_VALUE;

public class ShortestPath {

    private static final int M = 10;
    private static final int N = 10;

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                        {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                };

        // construct a matrix to keep track of visited cells
        int[][] visited = new int[M][N];

        int min_dist = findShortestPath(mat, visited, 0, 0, MAX_VALUE, 0);


        if (min_dist != MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.println("Destination can't be reached from source");
        }
    }

    private static boolean isSafe(int mat[][], int visited[][], int x, int y) {
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }

    private static boolean isValid(int x, int y) {
        return (x < M && y < N && x >= 0 && y >= 0);
    }


    private static int findShortestPath(int[][] mat, int[][] visited, int i, int j, int min_dist, int dist) {

        if (i == M - 1 && j == N - 1) {
            return Integer.min(dist + 1, min_dist);
        }
        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go to bottom cell
        if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
            min_dist = findShortestPath(mat, visited, i + 1, j, min_dist, dist + 1);
        }

        // go to right cell
        if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
            min_dist = findShortestPath(mat, visited, i, j + 1, min_dist, dist + 1);
        }

        // go to top cell
        if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
            min_dist = findShortestPath(mat, visited, i - 1, j, min_dist, dist + 1);
        }

        // go to left cell
        if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
            min_dist = findShortestPath(mat, visited, i, j - 1, min_dist, dist + 1);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return min_dist;
    }
}
