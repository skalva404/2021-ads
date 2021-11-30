package kalva.learnings.ads.companies.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class MaximumSquareSubMatrix {

    static int printMaxSubSquare(ArrayList<List<Integer>> M) {
        int S[][] = new int[M.size()][M.get(0).size()];
        for (int i = 0; i < M.size(); i++) {
            S[i][0] = M.get(i).get(0);
        }
        for (int i = 0; i < M.get(0).size(); i++) {
            S[0][i] = M.get(0).get(i);
        }

        for (int i = 1; i < M.size(); i++) {
            for (int j = 1; j < M.get(0).size(); j++) {
                if (1 == M.get(i).get(j)) {
                    S[i][j] = Math.min(Math.min(S[i][j - 1], S[i - 1][j]), S[i - 1][j - 1]) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        int max_of_s = S[0][0], max_i = 0, max_j = 0;
        for (int i = 0; i < M.size(); i++) {
            for (int j = 0; j < M.get(0).size(); j++) {
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return max_of_s;
    }

    static int printMaxSubSquare(int M[][]) {
        int S[][] = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            S[i][0] = M[i][0];
        }
        System.arraycopy(M[0], 0, S[0], 0, M[0].length);

        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (1 == M[i][j]) {
                    S[i][j] = min(min(S[i][j - 1], S[i - 1][j]), S[i - 1][j - 1]) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        int max_of_s = S[0][0], max_i = 0, max_j = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(S[i][j] + "\t");
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
            System.out.println();
        }
        return max_of_s;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> M = new ArrayList<List<Integer>>();
        M.add(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1));
        M.add(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0));
        M.add(Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1));
        M.add(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1));
        M.add(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1));
        M.add(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1));
//        System.out.println(printMaxSubSquare(M));

//        int M1[][] = {
//                {0, 1, 1, 0, 1},
//                {1, 1, 0, 1, 0},
//                {0, 1, 1, 1, 0},
//                {1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 0}};
        int M1[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};
        System.out.println(printMaxSubSquare(M1));
    }
}
