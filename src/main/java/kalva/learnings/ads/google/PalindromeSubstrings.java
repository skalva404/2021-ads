package kalva.learnings.ads.google;

public class PalindromeSubstrings {

    private static int dp(String str) {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int result = 0;

        for (int len = 1; len <= str.length(); len++) {
            for (int row = 0, col = row + len - 1; col < str.length(); row++, col++) {
                if (1 == len) {
                    dp[row][row] = true;
                    result++;
                } else if (2 == len) {
                    dp[row][row + 1] = str.charAt(row) == str.charAt(row + 1);
                    if (dp[row][row + 1]) {
                        result++;
                    }
                } else {
                    dp[row][col] = str.charAt(row) == str.charAt(col) && dp[row + 1][col - 1];
                    if (dp[row][col]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static int binary(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += isPalindrome(str, i, i);
            result += isPalindrome(str, i, i + 1);
        }
        return result;
    }

    private static int isPalindrome(String str, int s, int e) {
        int count = 0;
        while (s >= 0 && e < str.length() && str.charAt(s--) == str.charAt(e++)) {
            System.out.println(str.substring(s + 1, e));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(dp("abcbbc"));
        System.out.println(binary("abcbbc"));
    }
}
