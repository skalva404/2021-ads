package kalva.learnings.ads.twopointer;

import java.util.HashMap;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 * <p>
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {

    static int[] targetSum(int[] data, int targetSumValue) {
        int lp = 0, rp = data.length - 1;
        while (lp < rp) {
            int sum = data[lp] + data[rp];
            if (sum == targetSumValue) {
                return new int[]{lp, rp};
            } else if (sum < targetSumValue) {
                lp++;
            } else {
                rp--;
            }
        }
        return null;
    }

    public static int[] search(int[] arr, int targetSum) {

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (sumMap.containsKey(targetSum - arr[i])) {
                return new int[]{sumMap.get(targetSum - arr[i]), i};
            } else {
                sumMap.put(arr[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.targetSum(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.targetSum(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

        result = PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
