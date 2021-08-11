package kalva.learnings.ads.twopointer;

public class RemoveDuplicates {

    /**
     * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’
     * in-place and return the new length of the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
     * Output: 4
     * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
     * Example 2:
     * <p>
     * Input: [2, 11, 2, 2, 1], Key=2
     * Output: 2
     * Explanation: The first two elements after removing every 'Key' will be [11, 1].
     * Solution: This problem is quite similar to our parent problem.
     * We can follow a two-pointer approach and shift numbers left upon encountering the ‘key’.
     * Here is what the code will look like:
     *
     * @param arr
     * @return
     */
    public static int removeFromUnSortedArry(int[] arr, int targetKey) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != targetKey) {
                arr[count++] = arr[i];
            }
        }
        return count;
    }

    /**
     * Given an array of sorted numbers, remove all duplicates from it.
     * You should not use any extra space; after removing the duplicates in-place return the length of
     * the subarray that has no duplicate in it.
     * <p>
     * Example 1:
     * <p>
     * Input: [2, 3, 3, 3, 6, 9, 9]
     * Output: 4
     * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
     * Example 2:
     * <p>
     * Input: [2, 2, 2, 11]
     * Output: 2
     * Explanation: The first two elements after removing the duplicates will be [2, 11].
     *
     * @param arr
     * @return
     */
    private static int removeFromSortedArry(int[] arr) {
        int count = 1, nextDuplicate = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextDuplicate] != arr[i]) {
                arr[count] = arr[i];
                count++;
                nextDuplicate = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeFromSortedArry(arr));
        arr = new int[]{2, 2, 2, 11};
        System.out.println(removeFromSortedArry(arr));

        System.out.println("===========");
        arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(removeFromUnSortedArry(arr, 3));
        arr = new int[]{2, 11, 2, 2, 1};
        System.out.println(removeFromUnSortedArry(arr, 2));
    }
}
