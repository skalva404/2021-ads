package kalva.learnings.ads.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it
 * such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * <p>
 * x + y + z < target
 * y + Z < target - x
 * Example 1:
 * <p>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * <p>
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 *
 * <p>
 * Time complexity #
 * Sorting the array will take O(N * logN)O(N∗logN). The searchPair(), in this case, will take O(N^2)O(N
 * ​2
 * ​​ ); the main while loop will run in O(N)O(N) but the nested for loop can also take O(N)O(N) -
 * this will happen when the target sum is bigger than every triplet in the array.
 * <p>
 * So, overall searchTriplets() will take O(N * logN + N^3)O(N∗logN+N
 * ​3
 * ​​ ), which is asymptotically equivalent to O(N^3)O(N
 * ​3
 * ​​ ).
 * <p>
 * Space complexity #
 * Ignoring the space required for the output array, the space complexity of the above algorithm will
 * be O(N)O(N) which is required for sorting.
 * </p>
 */
public class TripletWithSmallerSum {

    public static List<List<Integer>> triplets(int[] arr, int target) {

        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            searchTriplets(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchTriplets(int[] arr, int target, int first, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        int left = first + 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                for (int i = right; i > left; i--) {
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.triplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletWithSmallerSum.triplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
