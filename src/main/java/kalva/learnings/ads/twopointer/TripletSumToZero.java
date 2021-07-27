package kalva.learnings.ads.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example 1:
 * <p>
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 * <p>
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 * Solution #
 * This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
 * A couple of differences are that the input array is not sorted and instead of a pair we need
 * to find triplets with a target sum of zero.
 * <p>
 * To follow a similar approach, first, we will sort the array and then iterate through it taking
 * one number at a time. Let’s say during our iteration we are at number ‘X’, so we need
 * to find ‘Y’ and ‘Z’ such that X + Y + Z == 0X+Y+Z==0. At this stage, our problem translates into
 * finding a pair whose sum is equal to “-X−X” (as from the above equation Y + Z == -XY+Z==−X).
 * <p>
 * Another difference from Pair with Target Sum is that we need to find all the unique triplets.
 * To handle this, we have to skip any duplicate number. Since we will be sorting the array, so all
 * the duplicate numbers will be next to each other and are easier to skip.
 */
public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            searchPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (targetSum == sum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
