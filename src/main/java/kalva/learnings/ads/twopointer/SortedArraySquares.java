package kalva.learnings.ads.twopointer;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the
 * input array in the sorted order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 * <p>
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
public class SortedArraySquares {

    private static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int index = arr.length - 1;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int ls = (int) Math.pow(arr[l], 2);
            int rs = (int) Math.pow(arr[r], 2);
            if (ls > rs) {
                squares[index--] = ls;
                l++;
            } else {
                squares[index--] = rs;
                r--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
