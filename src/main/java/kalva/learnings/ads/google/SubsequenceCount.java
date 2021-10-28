package kalva.learnings.ads.google;

/**
 * <pre>
 * 1. Given the string T is an empty string, returning 1 as an empty string can be the subsequence of all.
 * 2. Given the string S is an empty string, returning 0 as no string can be the subsequence of an empty string.
 * 3. If the last character of S and T do not match, then remove the last character of S and call the recursive function again. Because the last character of S
 * cannot be a part of the subsequence or remove it and check for other characters.
 * 4. If the last character of S match then there can be two possibilities, first there can be a subsequence where the last character of S is a part of it
 * and second where it is not a part of the subsequence. So the required value will be the sum of both. Call the recursive function once with
 * last character of both the strings removed and again with only last character of S removed.
 * </pre>
 */
public class SubsequenceCount {

    public static void main(String[] args) {
        String T = "ge";
        String S = "geeksforgeeks";
        System.out.println(numDistinct(S, T));
    }

    private static int numDistinct(String A, String B) {

        int m = B.length();
        int n = A.length();

        // T can't appear as a subsequence in S
        if (m > n)
            return 0;

        int mat[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            mat[i][0] = 0;

        for (int j = 0; j <= n; j++) {
            mat[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (B.charAt(i - 1) != A.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
            }
        }

        return mat[m][n];
    }
}
