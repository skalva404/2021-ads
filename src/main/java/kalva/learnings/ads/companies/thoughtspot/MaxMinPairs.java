package kalva.learnings.ads.companies.thoughtspot;

import java.util.Arrays;

public class MaxMinPairs {

    static int maxSum(int a[], int n) {

        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < n - 1; i += 2) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, 4};
//        int[] arr = {1, 3, 2, 1, 4, 5};
        int n = arr.length;

        System.out.println(maxSum(arr, n));
    }
}
