package kalva.learnings.ads.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Quadruple Sum to Target (medium) #
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it,
 * whose sum is equal to the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Example 2:
 * <p>
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                searchPairs(arr, target, i, j, quadruplets);
            }
        }

        return quadruplets;
    }

    private static void searchPairs(int[] arr, int target, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }
}
