package kalva.learnings.ads.arrays;

public class RainWater {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is " + findWater(arr));
    }

    private static int findWater(int[] input) {
        int total = 0;
        int n = input.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = input[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], input[i]);
        }

        right[n - 1] = input[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], input[i]);
        }

        for (int i = 1; i < input.length - 1; i++) {
            total += Math.min(left[i], right[i]) - input[i];
        }
        return total;
    }
}
