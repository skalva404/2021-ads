package kalva.learnings.ads.xor;

public class MissingNumber {

    private static int findMissingNumber(int[] arr) {

        int n = arr.length + 1;

        // find sum of all numbers from 1 to n.
        int x1 = 1;
        for (int i = 2; i <= n; i++)
            x1 = x1 ^ i;

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n - 1; i++)
            x2 = x2 ^ arr[i];

        return x1 ^ x2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6};
        System.out.print("Missing number is: " + MissingNumber.findMissingNumber(arr));
    }
}
