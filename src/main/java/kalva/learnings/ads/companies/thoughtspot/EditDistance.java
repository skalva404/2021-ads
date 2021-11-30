package kalva.learnings.ads.companies.thoughtspot;

import java.util.Arrays;

import static java.lang.Integer.min;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("kumar", "kalva"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] mem = new int[m][n];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return calDistance(word1, word2, mem, m - 1, n - 1);
    }

    private static int calDistance(String word1, String word2,
                                   int[][] mem, int l1, int l2) {

        if (l1 < 0) {
            return l2 + 1;
        } else if (l2 < 0) {
            return l1 + 1;
        }

        if (mem[l1][l2] != -1) {
            return mem[l1][l2];
        }

        if (word1.charAt(l1) == word2.charAt(l2)) {
            mem[l1][l2] = calDistance(word1, word2, mem, l1 - 1, l2 - 1);
        } else {
            int distance = min(min(
                    calDistance(word1, word2, mem, l1 - 1, l2),
                    calDistance(word1, word2, mem, l1, l2 - 1)
            ), calDistance(word1, word2, mem, l1 - 1, l2 - 1));
            mem[l1][l2] = 1 + distance;
        }
        return mem[l1][l2];
    }
}
