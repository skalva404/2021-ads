package kalva.learnings.ads.twopointer;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as c
 * lose to the target number as possible, return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * Example 2:
 * <p>
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 * <p>
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 * Solution #
 * This problem follows the Two Pointers pattern and is quite similar to Triplet Sum to Zero.
 * <p>
 * We can follow a similar approach to iterate through the array, taking one number at a time. At every step,
 * we will save the difference between the triplet and the target number, so that in the end, we can return the
 * triplet with the closest sum.
 */
public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) {
                    return targetSum - diff;
                }
                if (diff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
