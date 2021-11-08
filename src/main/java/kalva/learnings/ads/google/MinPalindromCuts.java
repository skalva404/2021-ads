package kalva.learnings.ads.google;

public class MinPalindromCuts {

    static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int topDown(String string, Integer dp[][], int i, int j) {

        if (i >= j || isPalindrome(string, i, j)) {
            return 0;
        }

        if (null != dp[i][j]) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE, count;
        for (int k = i; k < j; k++) {
            count = topDown(string, dp, i, k) +
                    topDown(string, dp, k + 1, j) + 1;
            ans = Math.min(ans, count);
        }
        dp[i][j] = ans;
        return ans;
    }

    public int minCut(String A) {
        return topDown(A, new Integer[A.length()][A.length()], 0, A.length() - 1);
    }

    static int bottomUp(String st) {

        // isPalindrome[i][j] will be 'true' if the string from
        // index 'i' to index 'j' is a palindrome
        boolean[][] isPalindrome = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++) {
            isPalindrome[i][i] = true;
        }

        // populate isPalindrome table
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || isPalindrome[startIndex + 1][endIndex - 1]) {
                        isPalindrome[startIndex][endIndex] = true;
                    }
                }
            }
        }

        // now lets populate the second table, every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        int[] cuts = new int[st.length()];
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            int minCuts = st.length(); // maximum cuts
            for (int endIndex = st.length() - 1; endIndex >= startIndex; endIndex--) {
                if (isPalindrome[startIndex][endIndex]) {
                    // we can cut here as we got a palindrome
                    // also we dont need any cut if the whole substring is a palindrome
                    minCuts = (endIndex == st.length() - 1) ? 0 : Math.min(minCuts, 1 + cuts[endIndex + 1]);
                }
            }
            cuts[startIndex] = minCuts;
        }

        return cuts[0];
    }

    public static void main(String args[]) {
        String str = "niiti";
//        String str = "nitia";
//        String str = "dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg";
        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is "
                + new MinPalindromCuts().minCut(str));

//        System.out.println(bottomUp("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg"));
    }
}
