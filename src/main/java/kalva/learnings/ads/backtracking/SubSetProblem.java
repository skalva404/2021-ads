package kalva.learnings.ads.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=1C1POwWszic
 */
public class SubSetProblem {

    static int loops = 0;

    static boolean bottomUp(int[] input, int sum) {

        boolean[][] dp = new boolean[input.length][sum];

        for (int i = 0; i < sum; i++) {
            if (input[0] == i + 1) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            boolean[] columns = dp[i];
            for (int j = 0; j < columns.length; j++) {
                if (j + 1 == input[i]) {
                    dp[i][j] = true;
                } else if (j + 1 < input[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] ||
                            dp[i - 1][(j + 1) - input[i] - 1];
                }
            }
        }
        return false;
    }

    static int memoizationTopDown(int[] data, int index, int sum,
                                  Map<String, Integer> memo) {

        if (index >= data.length) {
            return (0 == sum) ? 1 : 0;
        }

        if (null != memo.get(index + ":" + sum)) {
            return memo.get(index + ":" + sum);
        }

        int count = memoizationTopDown(data, index + 1, sum, memo) +
                memoizationTopDown(data, index + 1, sum - data[index], memo);
        memo.put(index + ":" + sum, count);

        return memo.get(index + ":" + sum);
    }

    static void recursive(int[] data, int n, int sum, List<Integer> list) {
        if (sum < 0) {
            return;
        }
        loops++;
        if (0 == sum) {
            printSubset(list);
            return;
        }
        if (0 == n) {
            return;
        }
        recursive(data, n - 1, sum, list);
        List<Integer> incList = new ArrayList<>(list);
        incList.add(data[n - 1]);
        recursive(data, n - 1, sum - data[n - 1], incList);
    }

    private static void printSubset(List<Integer> list) {
        System.out.print("Data :: ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = {2, 5, 8, 4, 6, 11};
        int sum = 13;
        int n = arr.length;
        recursive(arr, n, sum, new ArrayList<>());
        System.out.println();
//        System.out.println("Total loops " + loops);

        loops = 0;
        Map<String, Integer> memo = new HashMap<>();
        loops = memoizationTopDown(arr, 0, sum, memo);
        System.out.println("Total subsets " + loops);

        arr = new int[]{8, 2, 4, 5};
        System.out.println(bottomUp(arr, 10));
    }
}










