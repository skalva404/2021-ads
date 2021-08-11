package kalva.learnings.ads.twopointer;

/**
 * Problem Statement #
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s,
 * and 2s to recreate the array.
 * <p>
 * The flag of the Netherlands consists of three colors: red, white and blue;
 * and since our input array also consists of three different numbers that is why
 * it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 * <p>
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
public class DutchFlag {

    public static void sort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i <= right; ) {
            if (0 == arr[i]) {
                swap(arr, i, left);
                left++;
                i++;
            } else if (2 == arr[i]) {
                swap(arr, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int left) {
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
