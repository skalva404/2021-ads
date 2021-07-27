package kalva.learnings.ads.slidingwindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example 1:
 * <p>
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * Example 2:
 * <p>
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class ReplacingOnes {

    public static int findLength(int[] arr, int k) {

        int maxLenght = 0;
        int maxOnes = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                maxOnes++;
            }
            if (i - start + 1 - maxOnes > k) {
                if (1 == arr[start]) {
                    maxOnes--;
                }
                start++;
            }
            maxLenght = Math.max(maxLenght, i - start + 1);
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}