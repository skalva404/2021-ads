package kalva.learnings.ads.companies.thoughtspot;

public class BiggestIsland {

    static int maxhops = 0;

    static void DFS(int M[][], int row, int col) {

        if (row < 0 || col < 0 || row >= M.length || col >= M[0].length ||
                0 == M[row][col]) {
            return;
        }
        maxhops++;
        M[row][col] = 0;
        DFS(M, row - 1, col);
        DFS(M, row + 1, col);
        DFS(M, row, col - 1);
        DFS(M, row, col + 1);
    }

    private static void traverseIsland(int[][] islandDetails) {

        int max = maxhops;
        for (int i = 0; i < islandDetails.length; i++) {
            int[] islandDetail = islandDetails[i];
            for (int j = 0; j < islandDetail.length; j++) {
                if (1 == islandDetails[i][j]) {
                    maxhops = 0;
                    DFS(islandDetails, i, j);
                    max = Integer.max(max, maxhops);
                }
            }
        }
        System.out.println("max size = " + max);
    }

    public static void main(String args[]) {
        int arr[][] = new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 0}};
        traverseIsland(arr);
    }
}