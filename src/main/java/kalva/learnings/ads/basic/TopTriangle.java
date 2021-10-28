package kalva.learnings.ads.basic;

public class TopTriangle {
    public static void main(String[] args) {
        int r = 6;
        int c = 6;

        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = 0;
            }
        }

        String[] emoj = new String[]{"*","#","@","$",""};
        for (int column = 0; column < c; column++) {
            int ctr = 0;
            for (int row = 0; row < r - column; row++) {
                matrix[row][column + (ctr++)] = 1;
            }
            extracted(r, c, matrix);
        }
    }

    private static void extracted(int r, int c, int[][] matrix) {
        System.out.println();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
