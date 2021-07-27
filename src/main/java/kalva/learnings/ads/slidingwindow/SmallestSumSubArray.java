package kalva.learnings.ads.slidingwindow;

public class SmallestSumSubArray {

    private static int findMinSubArray(int sum, int[] arr) {

        int arrLen = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            while (windowSum >= sum) {
                arrLen = Math.min(arrLen, (i - windowStart) + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return arrLen;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }
}
