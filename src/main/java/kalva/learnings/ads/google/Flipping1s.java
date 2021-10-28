package kalva.learnings.ads.google;

public class Flipping1s {

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 0, 1, 1, 0};

        System.out.println(findMaxZeroCount(arr));
    }

    private static int findMaxZeroCount(int[] arr) {
        int soFar = 0;
        int total = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (0 == arr[i]) {
                zeroCount++;
            }
            int v = arr[i] == 1 ? 1 : -1;
            soFar = Math.max(v, soFar + v);
            total = Math.max(total, soFar);
        }
        total = Math.max(0, total);
        return total + zeroCount;
    }
}
