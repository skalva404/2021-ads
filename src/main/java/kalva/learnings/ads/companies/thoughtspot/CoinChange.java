package kalva.learnings.ads.companies.thoughtspot;

//https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
public class CoinChange {

    static int count(int[] c, int m, int n) {

        // If n is 0 then there is 1 solution
        if (0 == n) {
            return 1;
        }
        // If n is less than 0 then no solution exists
        if (n < 0) {
            return 0;
        }
        // If there are no coins and n is greater than 0, then no solution exist
        if (m <= 0 && n > 0) {
            return 0;
        }

        // count is sum of solutions
        // (i) including S[m-1] (ii) excluding S[m-1]
        return count(c, m, n - c[m - 1]) +
                count(c, m - 1, n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int m = arr.length;
        System.out.println(count(arr, m, 4));
    }
}
